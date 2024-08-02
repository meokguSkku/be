package com.restaurant.be.user.repository.v2.certification

interface CertifyUserRepositoryCustom {
    fun findWhetherTooManyRequest(phoneNumber: Long): Boolean

    fun countDayRequests(phoneNumber: Long): Long
}
