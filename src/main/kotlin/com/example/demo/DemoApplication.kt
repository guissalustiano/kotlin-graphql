package com.example.demo

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelNames
import com.expediagroup.graphql.generator.execution.KotlinDataFetcherFactoryProvider
import com.expediagroup.graphql.generator.hooks.NoopSchemaGeneratorHooks
import com.expediagroup.graphql.generator.hooks.SchemaGeneratorHooks
import com.expediagroup.graphql.server.spring.GraphQLConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class DemoApplication {
    @Bean
    fun schemaConfig(
        config: GraphQLConfigurationProperties,
        topLevelNames: Optional<TopLevelNames>,
        hooks: Optional<SchemaGeneratorHooks>,
        dataFetcherFactoryProvider: KotlinDataFetcherFactoryProvider
    ): SchemaGeneratorConfig {
        return SchemaGeneratorConfig(
            supportedPackages = config.packages,
            topLevelNames = topLevelNames.orElse(TopLevelNames()),
            hooks = CustomSchemaGeneratorHooks(),
            dataFetcherFactoryProvider = dataFetcherFactoryProvider,
            introspectionEnabled = config.introspection.enabled
        )
    }
}


fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
