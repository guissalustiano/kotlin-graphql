package com.example.demo.product

import com.example.demo.base.DeletePayload
import com.expediagroup.graphql.types.operations.Mutation
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProductMutation(private val service: ProductService) : Mutation {
    fun saveProduct(product: ProductEntity): ProductEntity {
        return service.save(product)
    }

    fun deleteProduct(id: UUID): DeletePayload {
        service.delete(id)
        return DeletePayload()
    }
}