package io.miso.apitest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApitestApplication

fun main(args: Array<String>) {
    runApplication<ApitestApplication>(*args)
}
