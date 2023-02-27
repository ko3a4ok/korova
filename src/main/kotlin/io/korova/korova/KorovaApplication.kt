package io.korova.korova

import io.korova.korova.model.Cow
import io.korova.korova.model.CowService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/korova")
class KorovaController (val service: CowService) {
	@GetMapping("/")
	fun all() = service.findCows()

	@GetMapping("/{id}")
	fun cow(@PathVariable id: Long) = service.findById(id)

	@PostMapping("/")
	fun save(@RequestBody cow: Cow) {
		service.save(cow)
	}
}

@Controller
class MainController (val userDetailsManager: UserDetailsService){

	@GetMapping("/")
	fun index(): String {
		return "index"
	}

	@GetMapping("/user/index")
	fun userIndex(): String {
		return "user/index"
	}

	@GetMapping("/log-in")
	fun login(): String {
		return "login"
	}

	@GetMapping("/signup")
	fun signup(): String {
		return "signup"
	}

	@PostMapping("/signup")
	fun register(@RequestParam username: String, @RequestParam password: String, req: HttpServletRequest) : String {
		val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
		(userDetailsManager as UserDetailsManager).createUser(User.builder().username(username).password(encoder.encode(password)).roles("USER").build())
		req.login(username, password)
		return "index"
	}
}
@SpringBootApplication
class KorovaApplication

fun main(args: Array<String>) {
	runApplication<KorovaApplication>(*args)
}
