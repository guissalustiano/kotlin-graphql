package com.example.demo.product
/*
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Query
import org.springframework.stereotype.Component


@Component
class ProductQuery(private val service: ProductService): Query {
    @GraphQLDescription("Search all categories")
    fun categories(): Iterable<ProductEntity> = service.findAll()
}
 */

import com.expediagroup.graphql.types.operations.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProductQuery(private val service: ProductService) : Query {
    fun findCategories(): List<ProductEntity> {
        return service.findAll().toList()
    }

    fun findProduct(id: UUID): ProductEntity {
        return service.findById(id)
    }
}