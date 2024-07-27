package com.restaurant.be.user.repository.certification

import com.restaurant.be.user.domain.entity.Certification
import org.springframework.data.jpa.repository.JpaRepository

interface CertifyUserRepository : JpaRepository<Certification, Long>, CertifyUserRepositoryCustom {
    fun findByPhoneNumber(phoneNumber: Long): Certification?

    fun findByPhoneNumberAndValid(phoneNumber: Long, valid: Boolean): List<Certification>
}
