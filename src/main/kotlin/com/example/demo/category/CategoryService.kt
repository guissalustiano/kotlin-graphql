package com.example.demo.category

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux

@Service
@Transactional
class CategoryService(
    @Autowired
    private val repository: CategoryRepository
) {

    fun findAll(): MutableIterable<CategoryEntity> {
        return repository.findAll()
    }

    fun findById(id: UUID): CategoryEntity {
        return repository.findById(id).orElseThrow{CategoryNotFoundException(id)}
    }

    fun save(CategoryEntity: CategoryEntity): CategoryEntity {
        return repository.save(CategoryEntity)
    }

    fun delete(id: UUID) {
        return repository.deleteById(id)
    }

}