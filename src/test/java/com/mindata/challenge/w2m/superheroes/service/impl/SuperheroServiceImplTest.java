package com.mindata.challenge.w2m.superheroes.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.repository.SuperheroRepository;

@SpringBootTest
class SuperheroServiceImplTest {

	@Mock
	private SuperheroRepository superheroRepository;

	@InjectMocks
	private SuperheroServiceImpl superheroService;

	@Test
	void testGetAllSuperheroes() {
		// Arrange
		Superhero spiderman = new Superhero(1L, "Peter Parker", "Spiderman", null);
		Superhero superman = new Superhero(2L, "Clark Kent", "Superman", null);
		List<Superhero> expectedSuperheroes = Arrays.asList(spiderman, superman);
		when(superheroRepository.findAll()).thenReturn(expectedSuperheroes);

		// Act
		List<Superhero> actualSuperheroes = superheroService.getAllSuperheroes();

		// Assert
		assertEquals(expectedSuperheroes, actualSuperheroes);
	}

	@Test
	void testGetSuperheroesByName() {
		// Arrange
		String name = "Spiderman";
		Superhero spiderman = new Superhero(1L, "Peter Parker", "Spiderman", null);
		List<Superhero> expectedSuperheroes = Arrays.asList(spiderman);
		when(superheroRepository.findByKeywordInNameIgnoreCase(name.toLowerCase())).thenReturn(expectedSuperheroes);

		// Act
		List<Superhero> actualSuperheroes = superheroService.getSuperheroesByName(name);

		// Assert
		assertEquals(expectedSuperheroes, actualSuperheroes);
	}

	@Test
	void testCreateSuperhero() {
		// Arrange
		Superhero spiderman = new Superhero(1L, "Peter Parker", "Spiderman", null);
		when(superheroRepository.save(any(Superhero.class))).thenReturn(spiderman);

		// Act
		Superhero savedSuperhero = superheroService.createSuperhero(spiderman);

		// Assert
		assertEquals(spiderman, savedSuperhero);
		verify(superheroRepository).save(spiderman);
	}

	@Test
	void testUpdateSuperhero() {
		// Arrange
		Long id = 1L;
		Superhero spiderman = new Superhero(id, "Peter Parker", "Spiderman", null);
		when(superheroRepository.save(any(Superhero.class))).thenReturn(spiderman);

		// Act
		Superhero updatedSuperhero = superheroService.updateSuperhero(id, spiderman);

		// Assert
		assertEquals(spiderman, updatedSuperhero);
		verify(superheroRepository).save(spiderman);
	}

	@Test
	void testDeleteSuperhero() {
		// Arrange
		Long id = 1L;

		// Act
		superheroService.deleteSuperhero(id);

		// Assert
		verify(superheroRepository).deleteById(id);
	}

	@Test
	void testGetSuperheroById() {
		// Arrange
		Long id = 1L;
		Superhero spiderman = new Superhero(id, "Peter Parker", "Spiderman", null);
		when(superheroRepository.findById(id)).thenReturn(Optional.of(spiderman));

		// Act
		Optional<Superhero> actualSuperhero = superheroService.getSuperheroById(id);

		// Assert
		assertTrue(actualSuperhero.isPresent());
		assertEquals(spiderman, actualSuperhero.get());
	}

}
