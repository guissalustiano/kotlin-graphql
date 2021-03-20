package com.example.demo.category

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository: CrudRepository<CategoryEntity, UUID> {
    fun findBySlug(slug: String): Optional<CategoryEntity>
}