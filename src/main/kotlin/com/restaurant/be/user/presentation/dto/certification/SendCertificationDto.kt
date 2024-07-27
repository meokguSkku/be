@file:Suppress("ktlint", "MatchingDeclarationName")

package com.restaurant.be.user.presentation.dto.certification

import com.restaurant.be.user.domain.entity.Certification
import io.swagger.annotations.ApiModelProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class SendCertificationRequest (
    @field:Pattern(regexp = "^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})\$", message = "알맞은 전화번호 형식이 아닙니다.")
    @field:NotBlank(message = "전화번호를 입력해 주세요.")
    @ApiModelProperty(value = "전화번호(하이픈 제외)", example = "01012345678", required = true)
    val phoneNumber: Long,
) {
    fun toEntity(certificationNumber: String): Certification {
        return Certification(
            phoneNumber = phoneNumber,
            certificationNumber = certificationNumber
        )
    }
}

data class SendCertificationResponse (
    @Schema(description = "인증번호 송신 전화번호")
    val phoneNumber: Long
)