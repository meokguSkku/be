package com.restaurant.be.user.domain.entity.embed

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class AccountPeriod(
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime?
)
