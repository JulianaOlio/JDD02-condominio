package com.example.condominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CondominioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CondominioApplication.class, args);
	}
}