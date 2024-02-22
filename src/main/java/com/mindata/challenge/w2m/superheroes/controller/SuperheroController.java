package com.mindata.challenge.w2m.superheroes.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.mindata.challenge.w2m.superheroes.annotation.ExecutionTime;
import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
@Api(value = "ControladorSuperheroes", produces = MediaType.APPLICATION_JSON_VALUE)
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@ExecutionTime
	@ApiOperation(value = "Obtener todos los superhéroes", notes = "Recupera todos los superhéroes de la base de datos")
	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
	}

	@ExecutionTime
	@ApiOperation(value = "Obtener superhéroe por ID", notes = "Recupera un superhéroe por su ID")
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Superhero getSuperheroById(@PathVariable Long id) {
		Optional<Superhero> opt = superheroService.getSuperheroById(id);
		return opt.orElseThrow(() -> new RuntimeException("Superhéroe no encontrado con el ID: " + id));
	}

	@ExecutionTime
	@ApiOperation(value = "Buscar superhéroes por nombre", notes = "Busca superhéroes por su nombre")
	@GetMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Superhero> getSuperheroesByName(@RequestParam String nombre) {
		return superheroService.getSuperheroesByName(nombre);
	}

	@ExecutionTime
	@ApiOperation(value = "Crear un nuevo superhéroe", notes = "Crea un nuevo superhéroe")
	@PostMapping(value = "/crear", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public Superhero createSuperhero(@RequestBody Superhero superhéroe) {
		return superheroService.createSuperhero(superhéroe);
	}

	@ExecutionTime
	@ApiOperation(value = "Actualizar un superhéroe", notes = "Actualiza un superhéroe existente por su ID")
	@PutMapping("/{id}")
	public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero superhéroe) {
		return superheroService.updateSuperhero(id, superhéroe);
	}

	@ExecutionTime
	@ApiOperation(value = "Eliminar un superhéroe", notes = "Elimina un superhéroe por su ID")
	@DeleteMapping("/{id}")
	public void deleteSuperhero(@PathVariable Long id) {
		superheroService.deleteSuperhero(id);
	}
}
