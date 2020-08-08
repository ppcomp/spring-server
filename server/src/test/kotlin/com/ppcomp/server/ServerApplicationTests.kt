package com.ppcomp.server

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.ResponseEntity
import java.net.URL


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIT {
	@LocalServerPort
	private val port = 0
	private var base: URL? = null

	@Autowired
	private lateinit var template: TestRestTemplate

	@BeforeEach
	@Throws(Exception::class)
	fun setUp() {
		base = URL("http://localhost:$port/")
	}

	@get:Throws(Exception::class)
	@get:Test
	val hello: Unit
		get() {
			val response: ResponseEntity<String> = template.getForEntity(
					base.toString(), String::class.java)
			assertThat(response.body).isEqualTo("Greetings from Spring Boot!" )
		}
}