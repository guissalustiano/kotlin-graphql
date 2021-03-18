package com.example.demo.category

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Mutation
import org.springframework.stereotype.Component

@Component
class CategoryMutation : Mutation {
    private val data: MutableList<String> = mutableListOf()

    @GraphQLDescription("add value to a list and return resulting list")
    fun addToList(entry: String): MutableList<String> {
        data.add(entry)
        return data
    }
}