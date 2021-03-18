package com.example.demo.category

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux

@Service
class CategoryService(
    @Autowired
    private var repository: CategoryRepository
) {

    fun getAll(): Flux<CategoryEntity> {
        return repository.findAll().switchIfEmpty(Flux.empty())
    }

    fun getById(id: UUID): Mono<CategoryEntity> {
        return repository.findById(id)
    }

    fun save(CategoryEntity: CategoryEntity): Mono<CategoryEntity> {
        return repository.save(CategoryEntity)
    }

    fun delete(id: UUID): Mono<Void> {
        return repository.deleteById(id)
    }

}