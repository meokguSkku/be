package com.restaurant.be.user.repository.v2

import com.restaurant.be.user.domain.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByPrivacyPhoneNumber(phoneNumber: Long): Member?
}
