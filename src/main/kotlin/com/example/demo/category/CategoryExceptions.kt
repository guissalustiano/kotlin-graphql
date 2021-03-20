package com.example.demo.category

import java.util.*

class CategoryNotFoundException(id: UUID) : RuntimeException("Could not find category $id")