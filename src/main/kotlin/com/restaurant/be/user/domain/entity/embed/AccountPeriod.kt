package com.restaurant.be.user.domain.entity.embed

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Column

data class AccountPeriod(
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime?
)
