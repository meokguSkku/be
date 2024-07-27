package com.restaurant.be.user.repository.certification

interface CertifyUserRepositoryCustom {
    fun findWhetherTooManyRequest(phoneNumber: Long): Boolean
}
