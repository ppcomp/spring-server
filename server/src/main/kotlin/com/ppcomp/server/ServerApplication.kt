package com.ppcomp.server

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*


fun main(args: Array<String>) {
	runApplication<ServerApplication>(*args)
}

@SpringBootApplication
class ServerApplication {
	@Bean
	fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
		return CommandLineRunner {
			println("Let's inspect the beans provided by Spring Boot:")
			val beanNames: Array<String> = ctx.beanDefinitionNames
			Arrays.sort(beanNames)
			for (beanName in beanNames) {
				println(beanName)
			}
		}
	}
}