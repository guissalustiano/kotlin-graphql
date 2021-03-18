package com.example.demo.category

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository: ReactiveMongoRepository<CategoryEntity, UUID>