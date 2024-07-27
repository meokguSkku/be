package com.restaurant.be.user.domain.entity.embed

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Email(
    @Column(name = "social_email")
    var socialEmail: String?,

    @Column(name = "school_email")
    var schoolEmail: String?
)
