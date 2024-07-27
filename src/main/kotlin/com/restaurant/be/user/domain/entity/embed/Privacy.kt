package com.restaurant.be.user.domain.entity.embed

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Privacy(
    @Column(name = "phone_number", nullable = false)
    var phoneNumber: Long,

    @Column(name = "real_name")
    var realName: String?,

    @Column(name = "birth_day")
    var birthDay: LocalDateTime?
)
