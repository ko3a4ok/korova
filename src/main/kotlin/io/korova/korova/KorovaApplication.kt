package io.korova.korova

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KorovaApplication

fun main(args: Array<String>) {
	runApplication<KorovaApplication>(*args)
}
