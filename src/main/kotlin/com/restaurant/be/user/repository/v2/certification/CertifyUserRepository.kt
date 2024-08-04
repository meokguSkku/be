package com.restaurant.be.user.repository.v2.certification

import com.restaurant.be.user.domain.entity.Certification
import org.springframework.data.jpa.repository.JpaRepository

interface CertifyUserRepository : JpaRepository<Certification, Long>, CertifyUserRepositoryCustom {
    fun findByPhoneNumber(phoneNumber: String): Certification?

    fun findByPhoneNumberAndValid(phoneNumber: String, valid: Boolean): List<Certification>

    fun findByPhoneNumberOrderByCreatedAtDesc(phoneNumber: String): List<Certification>

    companion object {
        const val MAX_MESSAGE_REQUESTS = 5
    }
}
