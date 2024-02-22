package com.mindata.challenge.w2m.superheroes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindata.challenge.w2m.superheroes.annotation.ExecutionTime;
import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/superheroes")
@Tag(name  = "ControladorSuperheroes", description = MediaType.APPLICATION_JSON_VALUE)
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@ExecutionTime
	@Operation(summary = "Obtener todos los superhéroes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupera todos los superhéroes de la base de datos"),
    })
	@GetMapping(value = "/todos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
	}

	@ExecutionTime
	@Operation(summary = "Obtener superhéroe por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupera un superhéroe por su ID"),
    })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Superhero getSuperheroById(@PathVariable Long id) {
		Optional<Superhero> opt = superheroService.getSuperheroById(id);
		return opt.orElseThrow(() -> new RuntimeException("Superhéroe no encontrado con el ID: " + id));
	}

	@ExecutionTime
	@Operation(summary = "Buscar superhéroes por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca superhéroes por su nombre"),
    })
	@GetMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Superhero> getSuperheroesByName(@RequestParam String nombre) {
		return superheroService.getSuperheroesByName(nombre);
	}

	@ExecutionTime
	@Operation(summary = "Crear un nuevo superhéroe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Crea un nuevo superhéroe"),
    })
	@PostMapping(value = "/crear", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public Superhero createSuperhero(@RequestBody Superhero superhéroe) {
		return superheroService.createSuperhero(superhéroe);
	}

	@ExecutionTime
	@Operation(summary = "Actualizar un superhéroe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actualiza un superhéroe existente por su ID"),
    })
	@PutMapping("/{id}")
	public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero superhéroe) {
		return superheroService.updateSuperhero(id, superhéroe);
	}

	@ExecutionTime
	@Operation(summary = "Eliminar un superhéroe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elimina un superhéroe por su ID"),
    })
	@DeleteMapping("/{id}")
	public void deleteSuperhero(@PathVariable Long id) {
		superheroService.deleteSuperhero(id);
	}
}
