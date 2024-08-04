package com.restaurant.be.user.repository.v2.certification

interface CertifyUserRepositoryCustom {
    fun findWhetherTooManyRequest(phoneNumber: String): Boolean

    fun countDayRequests(phoneNumber: String): Long
}
