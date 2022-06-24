package com.yunseok.r2dbc.config

import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.h2.tools.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
@EnableR2dbcRepositories
class H2DatabaseConfig : AbstractR2dbcConfiguration() {
    override fun connectionFactory(): ConnectionFactory {
        return H2ConnectionFactory.inMemory("testdb")
    }
    
    @Bean
    fun connectionFactoryInitializer(): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        val populator = ResourceDatabasePopulator()
        populator.addScript(ClassPathResource("sql/init-h2.sql"))
        initializer.setConnectionFactory(connectionFactory())
        initializer.setDatabasePopulator(populator)
        return initializer
    }
    
}

@Configuration
class MemoryDatabaseConfiguration {
    
    val webServer: Server = Server.createWebServer("-webPort", "9001")
    
    @EventListener(ContextRefreshedEvent::class)
    fun start() {
        webServer.start()
    }
    
    @EventListener(ContextClosedEvent::class)
    fun stop() {
        webServer.stop()
    }
}
