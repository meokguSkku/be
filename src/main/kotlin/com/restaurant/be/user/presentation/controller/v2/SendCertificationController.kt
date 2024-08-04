package com.restaurant.be.user.presentation.controller.v2

import com.restaurant.be.common.response.CommonResponse
import com.restaurant.be.user.domain.service.v2.SendCertificationService
import com.restaurant.be.user.presentation.dto.certification.SendCertificationRequest
import com.restaurant.be.user.presentation.dto.certification.SendCertificationResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["01. User Info"], description = "유저 기기 인증번호 전송 서비스")
@RestController
@RequestMapping("/v2/users/certification/request")
class SendCertificationController(
    private val sendCertificationService: SendCertificationService
) {
    @PostMapping
    @ApiOperation(value = "유저 기기 인증번호 전송 API")
    @ApiResponse(
        responseCode = "200",
        description = "성공",
        content = [Content(schema = Schema(implementation = SendCertificationResponse::class))]
    )
    fun sendCertificationToUser(
        @Valid @RequestBody
        request: SendCertificationRequest
    ): CommonResponse<SendCertificationResponse> {
        val response = sendCertificationService.sendCertificationToUser(request)
        return CommonResponse.success(response)
    }
}
