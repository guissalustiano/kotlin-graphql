package com.example.demo.product

import com.example.demo.base.BaseEntity
import com.example.demo.category.CategoryEntity
import com.example.demo.util.toSlug
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity
data class ProductEntity(
    @NotNull
    @Column(unique = true, nullable = false)
    var name: String,

    @NotNull
    @Column(unique = true, nullable = false)

    var slug: String? = name.toSlug(),

    var description: String? = "",

    @ManyToOne
    var category: CategoryEntity? = null,
) : BaseEntity()