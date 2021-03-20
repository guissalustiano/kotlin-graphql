package com.example.demo.base

import java.util.*
import javax.persistence.*

@MappedSuperclass
open class BaseEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null
//    @CreatedDate var createdAt: Date? = null,
//    var updatedAt: LocalDateTime = LocalDateTime.now()
)