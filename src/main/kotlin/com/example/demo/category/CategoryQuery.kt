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
import java.util.Random

data class CategoryPayload(
    var name: String
)

@Component
class CategoryQuery : Query {
    fun categories(): List<CategoryEntity> = listOf(CategoryEntity(name = "category bla bla"))

    @GraphQLDescription("generates pseudo random list of ints")
    fun generateList(): List<Int> {
        val random = Random()
        return (1..10).map { random.nextInt(100) }.toList()
    }
}