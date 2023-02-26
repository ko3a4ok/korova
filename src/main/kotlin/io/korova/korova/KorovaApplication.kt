package io.korova.korova

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MainController {
	@GetMapping("/{id}")
	fun main(@PathVariable id: String) = "ololo $id"
}
@SpringBootApplication
class KorovaApplication

fun main(args: Array<String>) {
	runApplication<KorovaApplication>(*args)
}
