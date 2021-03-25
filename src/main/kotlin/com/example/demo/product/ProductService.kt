package com.example.demo.product

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class ProductService(
    @Autowired
    private val repository: ProductRepository
) {

    fun findAll(): MutableIterable<ProductEntity> {
        return repository.findAll()
    }

    fun findById(id: UUID): ProductEntity {
        return repository.findById(id).orElseThrow { ProductNotFoundException(id) }
    }

    fun save(ProductEntity: ProductEntity): ProductEntity {
        return repository.save(ProductEntity)
    }

    fun delete(id: UUID) {
        return repository.deleteById(id)
    }

}