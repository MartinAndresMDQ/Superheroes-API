package com.mindata.challenge.w2m.superheroes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@ComponentScan
//@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackages = { "com.mindata.challenge.w2m.superheroes.model" })
@ComponentScan(basePackages = { "com.mindata.challenge.w2m.superheroes.*" })
@EnableJpaRepositories(basePackages = { "com.mindata.challenge.w2m.superheroes.*" })
//@EnableJpaRepositories("com.mindata.challenge.w2m.superheroes.*")
//@ComponentScan(basePackages = { "com.mindata.challenge.w2m.superheroes.*" })
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SuperheroesApiApplication {

	private static final Logger log = LoggerFactory.getLogger(SuperheroesApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApiApplication.class, args);
	}

//	  @Bean
//	  public CommandLineRunner demo(SuperheroRepository repository) {
//	    return (args) -> {
//	      // save a few customers
//	      repository.save(new Superhero("Jack", "Bauer"));
//	      repository.save(new Superhero("Chloe", "O'Brian"));
//	      repository.save(new Superhero("Kim", "Bauer"));
//	      repository.save(new Superhero("David", "Palmer"));
//	      repository.save(new Superhero("Michelle", "Dessler"));
//
//	      // fetch all customers
//	      log.info("Customers found with findAll():");
//	      log.info("-------------------------------");
//	      repository.findAll().forEach(customer -> {
//	        log.info(customer.toString());
//	      });
//	      log.info("");
//
//	      // fetch an individual customer by ID
//	      Optional<Superhero> customer = repository.findById(1L);
//	      log.info("Customer found with findById(1L):");
//	      log.info("--------------------------------");
//	      log.info(customer.toString());
//	      log.info("");
//
//	      // fetch customers by last name
//	      log.info("Customer found with findByLastName('Bauer'):");
//	      log.info("--------------------------------------------");
//	      repository.findByNameContaining("Bauer").forEach(bauer -> {
//	        log.info(bauer.toString());
//	      });
//	      log.info("");
//	    };
//	  }

}
