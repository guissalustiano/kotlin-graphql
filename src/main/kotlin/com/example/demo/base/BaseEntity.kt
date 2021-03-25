package com.example.demo.base

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null
//    @CreatedDate var createdAt: Date? = null,
//    var updatedAt: LocalDateTime = LocalDateTime.now()
)