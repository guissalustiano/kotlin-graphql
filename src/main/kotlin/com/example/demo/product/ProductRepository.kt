package com.example.demo.product

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : CrudRepository<ProductEntity, UUID> {
    fun findBySlug(slug: String): Optional<ProductEntity>
}