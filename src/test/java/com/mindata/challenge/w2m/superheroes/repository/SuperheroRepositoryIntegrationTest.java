package com.mindata.challenge.w2m.superheroes.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mindata.challenge.w2m.superheroes.model.Superhero;

@DataJpaTest
public class SuperheroRepositoryIntegrationTest {

	@Autowired
	private SuperheroRepository superheroRepository;

	@Test
	public void testFindByKeywordInNameIgnoreCase() {
		// Arrange
		Superhero spiderman = new Superhero("Peter Parker", "Spiderman");
		superheroRepository.save(spiderman);

		// Act
		List<Superhero> foundSuperheroes = superheroRepository.findByKeywordInNameIgnoreCase("man");

		// Assert
		assertTrue(foundSuperheroes.size() > 0);
		assertTrue(foundSuperheroes.contains(spiderman));
	}

	@Test
	public void testFindByNameContaining() {
		// Arrange
		Superhero superman = new Superhero("Clark Kent", "Superman");
		superheroRepository.save(superman);

		// Act
		List<Superhero> foundSuperheroes = superheroRepository.findByNameContaining("man");

		// Assert
		assertTrue(foundSuperheroes.size() > 0);
		assertTrue(foundSuperheroes.contains(superman));
	}

	@Test
	public void testFindById() {
		// Arrange
		Superhero spiderman = new Superhero("Peter Parker", "Spiderman");
		Superhero savedSuperhero = superheroRepository.save(spiderman);

		// Act
		Optional<Superhero> foundSuperhero = superheroRepository.findById(savedSuperhero.getId());

		// Assert
		assertTrue(foundSuperhero.isPresent());
		assertEquals(savedSuperhero, foundSuperhero.get());
	}
}
