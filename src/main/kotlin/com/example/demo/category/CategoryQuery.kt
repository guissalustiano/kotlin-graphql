package com.example.demo.category
/*
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Query
import org.springframework.stereotype.Component


@Component
class CategoryQuery(private val service: CategoryService): Query {
    @GraphQLDescription("Search all categories")
    fun categories(): Iterable<CategoryEntity> = service.findAll()
}
 */

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoryQuery(private val service: CategoryService) : Query {
    fun findCategories(): List<CategoryEntity> {
        return service.findAll().toList()
    }

    fun findCategory(id: UUID): CategoryEntity {
        return service.findById(id)
    }
}