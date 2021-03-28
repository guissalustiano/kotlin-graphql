package com.example.demo.category

import com.example.demo.base.BaseEntity
import com.example.demo.product.ProductEntity
import com.example.demo.util.toSlug
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.validation.constraints.NotNull

@Entity
data class CategoryEntity(
    @NotNull
    @Column(unique = true, nullable = false)
    var name: String,

    @NotNull
    @Column(unique = true, nullable = false)
    var slug: String = name.toSlug(),

    @OneToMany
    var products: MutableList<ProductEntity>? = mutableListOf(),
) : BaseEntity()