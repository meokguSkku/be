package com.restaurant.be.user.repository.certification

import com.querydsl.jpa.impl.JPAQueryFactory
import com.restaurant.be.user.domain.entity.QCertification.certification
import org.springframework.data.jpa.domain.Specification.where
import java.time.LocalDateTime
import java.util.*

class CertifyUserRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : CertifyUserRepositoryCustom {

    val MAX_REQUESTS: Long = 5
    override fun findWhetherTooManyRequest(phoneNumber: Long): Boolean {
        return countValidRequests(phoneNumber) >= MAX_REQUESTS
    }
    private fun countValidRequests(phoneNumber: Long): Long {
        val currentTime = LocalDateTime.now()
        val aDayBeforeCurrentTime = currentTime.minusDays(1)
        return queryFactory
            .select(certification.count())
            .from(certification)
            .where(
                certification.phoneNumber.eq(phoneNumber)
                    .and(certification.createdAt.after(aDayBeforeCurrentTime))
            )
            .fetchOne() ?: 0L
    }
}
