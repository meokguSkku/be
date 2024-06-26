package com.restaurant.be.common.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity {

    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        set

    @LastModifiedDate
    var modifiedAt: LocalDateTime = LocalDateTime.now()
        set
}
