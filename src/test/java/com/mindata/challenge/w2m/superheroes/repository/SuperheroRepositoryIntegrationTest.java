package com.mindata.challenge.w2m.superheroes.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindata.challenge.w2m.superheroes.model.Superhero;

@SpringBootTest
class SuperheroRepositoryIntegrationTest {

	@Autowired
	private SuperheroRepository superheroRepository;

	@Test
	void testFindByKeywordInNameIgnoreCase() {
		// Arrange
		Superhero spiderman = new Superhero("Peter Parker", "Spiderman");
		superheroRepository.save(spiderman);

		// Act
		List<Superhero> foundSuperheroes = superheroRepository.findByKeywordInNameIgnoreCase("derman");

		// Assert
		assertTrue(foundSuperheroes.size() > 0);
		boolean supermanFound = false;
		for (Superhero superhero : foundSuperheroes) {
			if (superhero.getId().equals(spiderman.getId()) && superhero.getName().equals(spiderman.getName())
					&& superhero.getName_super().equals(spiderman.getName_super())) {
				supermanFound = true;
				break;
			}
		}

		assertTrue(supermanFound);
	}

	@Test
	void testFindByNameContaining() {
		// Arrange
		Superhero superman = new Superhero("Clark Kent", "Superman");
		superman = superheroRepository.save(superman);

		// Act
		List<Superhero> foundSuperheroes = superheroRepository.findByNameContaining("ent");

		// Assert
		assertTrue(foundSuperheroes.size() > 0);
		boolean supermanFound = false;
		for (Superhero superhero : foundSuperheroes) {
			if (superhero.getId().equals(superman.getId()) && superhero.getName().equals(superman.getName())
					&& superhero.getName_super().equals(superman.getName_super())) {
				supermanFound = true;
				break;
			}
		}

		assertTrue(supermanFound);
	}

	@Test
	void testFindById() {
		// Arrange
		Superhero spiderman = new Superhero("Peter Parker", "Spiderman");
		Superhero savedSuperhero = superheroRepository.save(spiderman);

		// Act
		Superhero foundSuperhero = superheroRepository.findById(savedSuperhero.getId()).orElse(null);

		// Assert
		assertEquals(savedSuperhero.getId(), foundSuperhero.getId());
		assertEquals(savedSuperhero.getName(), foundSuperhero.getName());
		assertEquals(savedSuperhero.getName_super(), foundSuperhero.getName_super());
	}
}
