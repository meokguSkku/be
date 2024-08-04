package com.restaurant.be.user.presentation.controller.v2

import com.restaurant.be.common.response.CommonResponse
import com.restaurant.be.user.domain.service.v2.CertifyUserService
import com.restaurant.be.user.presentation.dto.certification.CertifyUserRequest
import com.restaurant.be.user.presentation.dto.certification.CertifyUserResponse
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

@Api(tags = ["01. User Info"], description = "유저 기기 인증번호 확인 서비스")
@RestController
@RequestMapping("/v2/users/certification")
class CertifyUserController(
    private val certifyUserService: CertifyUserService
) {
    @PostMapping
    @ApiOperation(value = "유저 기기 인증번호 확인 API")
    @ApiResponse(
        responseCode = "200",
        description = "성공",
        content = [Content(schema = Schema(implementation = CertifyUserResponse::class))]
    )
    fun certifyUser(
        @Valid @RequestBody
        request: CertifyUserRequest
    ): CommonResponse<CertifyUserResponse> {
        val response = certifyUserService.certify(request)
        return CommonResponse.success(response)
    }
}
