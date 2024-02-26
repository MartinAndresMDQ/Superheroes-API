package com.mindata.challenge.w2m.superheroes.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindata.challenge.w2m.superheroes.model.Power;
import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.repository.PowerRepository;
import com.mindata.challenge.w2m.superheroes.repository.SuperheroRepository;

@SpringBootTest
class SuperheroServiceImplTest {

	@Mock
	private SuperheroRepository superheroRepository;
	
    @MockBean
    private PowerRepository powerRepository;

	@InjectMocks
	private SuperheroServiceImpl superheroService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

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
	public void testUpdateSuperhero() {
		// Configuración de datos de prueba
		Long superheroId = 1L;
		Superhero existingSuperhero = new Superhero(superheroId, "Superman", "Clark Kent", new HashSet<>());
		Set<Power> powers = new HashSet<>();
		powers.add(new Power("Vuela"));
		existingSuperhero.setPowers(powers);

		Superhero updatedSuperhero = new Superhero(superheroId, "Batman", "Bruce Wayne", new HashSet<>());
		Set<Power> updatedPowers = new HashSet<>();
		updatedPowers.add(new Power("Fuerza"));
		updatedSuperhero.setPowers(updatedPowers);

		// Simular el comportamiento del repositorio
		when(superheroRepository.existsById(superheroId)).thenReturn(true);
		when(superheroRepository.save(updatedSuperhero)).thenReturn(updatedSuperhero);

		// Ejecutar el método a probar
		Superhero result = superheroService.updateSuperhero(superheroId, updatedSuperhero);

		// Verificar el resultado
		assertEquals(updatedSuperhero, result);
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
