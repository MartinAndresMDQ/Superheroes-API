package com.mindata.challenge.w2m.superheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.mindata.challenge.w2m.superheroes.model")
@EnableJpaRepositories(basePackages = {"com.mindata.challenge.w2m.superheroes.repository"})
public class SuperheroesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApiApplication.class, args);
	}

}
