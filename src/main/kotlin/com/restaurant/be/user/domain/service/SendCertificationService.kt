package com.restaurant.be.user.domain.service

import com.restaurant.be.common.exception.MessageServerException
import com.restaurant.be.common.exception.TooManyCertifyRequestException
import com.restaurant.be.user.presentation.dto.certification.SendCertificationRequest
import com.restaurant.be.user.presentation.dto.certification.SendCertificationResponse
import com.restaurant.be.user.presentation.dto.certification.SendMessageResponse
import com.restaurant.be.user.repository.certification.CertifyUserRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import kotlin.random.Random

@Service
class SendCertificationService(
    private val sendCertificationRepository: CertifyUserRepository,
    @Value("\${aligo.key}") private val apiKey: String,
    @Value("\${aligo.userId}") private val userId: String,
    @Value("\${aligo.sender}") private val sender: String
) {
    private val webClient: WebClient = WebClient.builder()
        .baseUrl("https://apis.aligo.in/send/")
        .build()

    @Transactional
    fun sendCertificationToUser(request: SendCertificationRequest): SendCertificationResponse {
        val phoneNumber = request.phoneNumber

        handleTooManySendMessages(phoneNumber)
        handleExistingCertifications(phoneNumber)

        val randomUUID = createRandomUUID()
        postMessage(phoneNumber.toString(), createMessage(randomUUID), "Y")
            .subscribe {
                    response ->
                if (response.resultCode < 0) {
                    throw MessageServerException()
                }
                sendCertificationRepository.save(request.toEntity(randomUUID))
            }

        return SendCertificationResponse(phoneNumber)
    }

    private fun handleTooManySendMessages(phoneNumber: Long) {
        if (sendCertificationRepository.findWhetherTooManyRequest(phoneNumber)) {
            throw TooManyCertifyRequestException()
        }
    }

    private fun handleExistingCertifications(phoneNumber: Long) {
        val existingCertifications = sendCertificationRepository.findByPhoneNumberAndValid(phoneNumber, true)
        if (existingCertifications.isNotEmpty()) {
            for (certification in existingCertifications) {
                certification.valid = false
            }
        }
    }

    private fun createRandomUUID(): String {
        val randomNumber = Random.nextInt(0, 1000000)
        return randomNumber.toString().padStart(6, '0')
    }

    private fun createMessage(randomUUID: String): String {
        return """
            인증번호 [$randomUUID]
            '다이닝버디' 회원가입/로그인 인증번호입니다. 
        """.trimIndent()
    }
    private fun postMessage(
        receiver: String,
        msg: String,
        testmodeYN: String
    ): Mono<SendMessageResponse> {
        return webClient.post()
            .body(
                BodyInserters.fromFormData("key", apiKey)
                    .with("user_id", userId)
                    .with("sender", sender)
                    .with("receiver", receiver)
                    .with("msg", msg)
                    .with("testmode_yn", testmodeYN)
            )
            .retrieve()
            .bodyToMono(SendMessageResponse::class.java)
    }
}
