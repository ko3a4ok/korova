package io.korova.korova

import io.korova.korova.model.Cow
import io.korova.korova.model.CowService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MainController (val service: CowService) {
	@GetMapping("/")
	fun all() = service.findCows()

	@GetMapping("/{id}")
	fun cow(@PathVariable id: Long) = service.findById(id)

	@PostMapping("/")
	fun save(@RequestBody cow: Cow) {
		service.save(cow)
	}
}
@SpringBootApplication
class KorovaApplication

fun main(args: Array<String>) {
	runApplication<KorovaApplication>(*args)
}
