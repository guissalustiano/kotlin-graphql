package com.example.demo.product

import com.example.demo.base.BaseEntity
import com.example.demo.util.toSlug
import javax.persistence.Entity

@Entity
data class ProductEntity(
    var name: String,
    var slug: String? = name.toSlug(),
) : BaseEntity()