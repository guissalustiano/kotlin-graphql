package com.example.demo.category

import com.example.demo.base.DeletePayload
import com.expediagroup.graphql.types.operations.Mutation
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoryMutation(private val service: CategoryService) : Mutation {
    fun saveCategory(category: CategoryEntity): CategoryEntity {
        return service.save(category)
    }

    fun deleteCategory(id: UUID): DeletePayload {
        service.delete(id)
        return DeletePayload()
    }
}