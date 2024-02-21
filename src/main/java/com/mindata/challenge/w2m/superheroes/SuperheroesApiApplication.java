package com.mindata.challenge.w2m.superheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ServletComponentScan
@ComponentScan(basePackages = {"com.mindata.challenge.w2m.superheroes.repository"})
@AutoConfigurationPackage
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SuperheroesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApiApplication.class, args);
	}

}
