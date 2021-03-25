package com.example.demo.product

import java.util.*

class ProductNotFoundException(id: UUID) : RuntimeException("Could not find product $id")