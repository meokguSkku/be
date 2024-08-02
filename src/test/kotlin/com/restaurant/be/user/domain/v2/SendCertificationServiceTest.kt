package com.restaurant.be.user.domain.v2

import com.restaurant.be.common.IntegrationTest
import com.restaurant.be.user.domain.service.v2.SendCertificationService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@IntegrationTest
@Transactional
class SendMessageIntegrationTest (
    private val sendCertificationService: SendCertificationService,
    private val webClient: WebClient,
){

}