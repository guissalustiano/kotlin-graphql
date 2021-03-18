package com.example.demo.category

import com.example.demo.base.BaseEntity
import org.springframework.data.annotation.Id
import com.example.demo.util.toSlug
import com.expediagroup.graphql.generator.scalars.ID
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class CategoryEntity(
    var name: String,
    var slug: String = name.toSlug(),
): BaseEntity()