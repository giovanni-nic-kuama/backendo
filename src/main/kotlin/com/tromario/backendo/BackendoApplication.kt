package com.tromario.backendo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.tromario.backendo.modules.**")
@ComponentScan("com.tromario.backendo.modules.**")
class BackendoApplication

fun main(args: Array<String>) {
    runApplication<BackendoApplication>(*args)
}

