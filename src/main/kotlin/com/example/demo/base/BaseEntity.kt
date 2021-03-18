package com.example.demo.base

import com.expediagroup.graphql.generator.scalars.ID
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

open class BaseEntity (
    @Id var id: ID = ID(UUID.randomUUID().toString()),
//    @CreatedDate var createdAt: Date? = null,
//    var updatedAt: LocalDateTime = LocalDateTime.now()
)