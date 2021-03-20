package com.example.demo.integration

import com.example.demo.category.CategoryEntity
import com.example.demo.category.CategoryRepository
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.hamcrest.Matchers.hasSize

@SpringBootTest
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class CategoryTest(
    @Autowired private val testClient: WebTestClient,
    @Autowired private val repository: CategoryRepository
) {
    var fake = CategoryEntity(name="Category 1")

    @BeforeEach
    fun setup() {
        fake = repository.save(fake)
    }

    @AfterEach
    fun clean() {
        repository.findById(fake.id!!).ifPresent { repository.delete(it) }
    }

    @Test
    fun `verify findAll`() {
        testClient
            .graphql("{ findCategories { id } }")
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$DATA_JSON_PATH.findCategories").value(hasSize<Int>(1))
    }

    @Test
    fun `verify find`() {
        testClient
            .graphql("{ findCategory(id: \"${fake.id}\") { id } }")
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$DATA_JSON_PATH.findCategory.id").isEqualTo(fake.id.toString())
    }

    @Test
    fun `verify save`() {
        testClient
            .graphql("mutation { " +
                    "   saveCategory(" +
                    "       category: { name: \"sugar potato\" }" +
                    ") { slug } }")
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$DATA_JSON_PATH.saveCategory.slug")
                .isEqualTo("sugar-potato")

        repository.findBySlug("sugar-potato").let {
            assert(it.isPresent)
            repository.delete(it.get())
        }
    }
    @Test
    fun `verify delete`() {
        testClient
            .graphql("mutation { deleteCategory(id: \"${fake.id}\") { status } }")
            .expectBody()
            .jsonPath("$DATA_JSON_PATH.deleteCategory.status")
            .isEqualTo(true)
    }

}


