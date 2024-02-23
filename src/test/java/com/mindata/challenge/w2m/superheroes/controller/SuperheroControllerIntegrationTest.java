package com.mindata.challenge.w2m.superheroes.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

@SpringBootTest
@AutoConfigureMockMvc
class SuperheroControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SuperheroService superheroService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testGetAllSuperheroes() throws Exception {
		Mockito.when(superheroService.getAllSuperheroes()).thenReturn(Collections.emptyList());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/superheroes/todos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

		Mockito.verify(superheroService, times(1)).getAllSuperheroes();
	}

	@Test
	void testGetSuperheroById() throws Exception {
		Long id = 1L;
		Superhero spiderman = new Superhero(id, "Peter Parker", "Spiderman", new HashSet<>());
		Mockito.when(superheroService.getSuperheroById(id)).thenReturn(Optional.of(spiderman));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/superheroes/traer/{id}", id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(spiderman.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(spiderman.getName()));

		Mockito.verify(superheroService, times(1)).getSuperheroById(id);
	}

	@Test
	void testGetSuperheroesByName() throws Exception {
		String name = "Spider";
		Superhero spiderman = new Superhero(1L, "Peter Parker", "Spiderman", new HashSet<>());
		List<Superhero> spiderHeroes = Collections.singletonList(spiderman);
		Mockito.when(superheroService.getSuperheroesByName(name)).thenReturn(spiderHeroes);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/superheroes/buscar").param("nombre", name)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(spiderman.getName()));

		Mockito.verify(superheroService, times(1)).getSuperheroesByName(name);
	}

	@Test
	void testCreateSuperhero() throws Exception {
		Superhero spiderman = new Superhero(1L, "Peter Parker", "Spiderman", new HashSet<>());
		Mockito.when(superheroService.createSuperhero(any(Superhero.class))).thenReturn(spiderman);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/superheroes/crear")
				.content(objectMapper.writeValueAsString(spiderman)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(spiderman.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(spiderman.getName()));

		Mockito.verify(superheroService, times(1)).createSuperhero(any(Superhero.class));
	}

	@Test
	void testUpdateSuperhero() throws Exception {
		Long id = 1L;
		Superhero updatedSpiderman = new Superhero(id, "Peter Parker", "Spiderman", new HashSet<>());
		Mockito.when(superheroService.updateSuperhero(eq(id), any(Superhero.class))).thenReturn(updatedSpiderman);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/superheroes/actualizar/{id}", id)
				.content(objectMapper.writeValueAsString(updatedSpiderman)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(updatedSpiderman.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(updatedSpiderman.getName()));

		Mockito.verify(superheroService, times(1)).updateSuperhero(eq(id), any(Superhero.class));
	}

	@Test
	void testDeleteSuperhero() throws Exception {
		Long id = 1L;

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/api/superheroes/borrar/{id}", id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Mockito.verify(superheroService, times(1)).deleteSuperhero(id);
	}

}
