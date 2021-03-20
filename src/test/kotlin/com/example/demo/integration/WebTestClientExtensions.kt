package com.example.demo.integration

import com.example.demo.integration.*
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.reactive.server.WebTestClient

fun WebTestClient.graphql(query: String): WebTestClient.ResponseSpec {
    return this.post()
        .uri(GRAPHQL_ENDPOINT)
            .accept(APPLICATION_JSON)
            .contentType(GRAPHQL_MEDIA_TYPE)
            .bodyValue(query)
            .exchange()
}