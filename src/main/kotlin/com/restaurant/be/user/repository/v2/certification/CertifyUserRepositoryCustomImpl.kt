package com.restaurant.be.user.repository.v2.certification

import com.querydsl.jpa.impl.JPAQueryFactory
import com.restaurant.be.user.domain.entity.QCertification.certification
import com.restaurant.be.user.repository.v2.certification.CertifyUserRepository.Companion.MAX_MESSAGE_REQUESTS
import java.time.LocalDateTime
import java.util.*

class CertifyUserRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : CertifyUserRepositoryCustom {

    override fun findWhetherTooManyRequest(phoneNumber: String): Boolean {
        return countDayRequests(phoneNumber) >= MAX_MESSAGE_REQUESTS
    }

    override fun countDayRequests(phoneNumber: String): Long {
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
