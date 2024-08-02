@file:Suppress("ktlint", "MatchingDeclarationName")

package com.restaurant.be.user.presentation.dto.certification

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull

data class SendMessageResponse(
    @JsonProperty("result_code")
    @field:NotNull
    val resultCode: Int,

    @field:NotNull
    val message: String
)
