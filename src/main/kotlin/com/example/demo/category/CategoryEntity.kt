package com.example.demo.category

import com.example.demo.base.BaseEntity
import com.example.demo.util.toSlug
import javax.persistence.Entity

@Entity
data class CategoryEntity(
    var name: String,
    var slug: String? = name.toSlug(),
) : BaseEntity()