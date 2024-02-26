package com.mindata.challenge.w2m.superheroes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
//@PropertySource("mensajes.properties")
@Tag(name = "ControladorSuperheroes", description = MediaType.APPLICATION_JSON_VALUE)
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@ExecutionTime
	@Operation(summary = "Obtener todos los superhéroes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recupera todos los superhéroes de la base de datos"), })
	@GetMapping(value = "/todos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
	}

	@ExecutionTime
	@Operation(summary = "Obtener superhéroe por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Recupera un superhéroe por su ID"),
			@ApiResponse(responseCode = "404", description = "Superhéroe no encontrado") })
	@GetMapping(value = "/traer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getSuperheroById(@PathVariable Long id) {
		Optional<Superhero> opt = superheroService.getSuperheroById(id);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		else
			return new ResponseEntity<>("El superhéroe con ID " + id + " no existe", HttpStatus.NOT_FOUND);

	}

	@ExecutionTime
	@Operation(summary = "Buscar superhéroes por nombre")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Busca superhéroes por su nombre"), })
	@GetMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getSuperheroesByName(@RequestParam String nombre) {
		List<Superhero> opt = superheroService.getSuperheroesByName(nombre);
		if (opt.size() > 0)
			return ResponseEntity.ok(opt);
		else
			return new ResponseEntity<>("No se encontraron superhéroes que contengan el nombre:" + nombre,
					HttpStatus.NOT_FOUND);
	}

	@ExecutionTime
	@Operation(summary = "Crear un nuevo superhéroe")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Crea un nuevo superhéroe"),
			@ApiResponse(responseCode = "400", description = "No se pudo crear el superhéroe") })
	@PostMapping(value = "/crear", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createSuperhero(@RequestBody Superhero superhéroe) {
		Superhero createdSuperhero = superheroService.createSuperhero(superhéroe);
		if (createdSuperhero != null)
			return ResponseEntity.ok(createdSuperhero);
		else
			return new ResponseEntity<>("Hubo un error al crear el superheroe", HttpStatus.NOT_FOUND);

	}

	@ExecutionTime
	@Operation(summary = "Actualizar un superhéroe")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Actualiza un superhéroe existente por su ID"),
			@ApiResponse(responseCode = "404", description = "Superhéroe no encontrado") })
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> updateSuperhero(@PathVariable Long id, @RequestBody Superhero superhéroe) {
		Superhero updatedSuperhero = superheroService.updateSuperhero(id, superhéroe);
		if (updatedSuperhero != null) {
			return ResponseEntity.ok(updatedSuperhero);
		} else {
			return new ResponseEntity<>("El superhéroe con ID " + id + " no existe", HttpStatus.NOT_FOUND);
		}
	}

	@ExecutionTime
	@Operation(summary = "Eliminar un superhéroe")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "El superhéroe se eliminó con éxito"),
			@ApiResponse(responseCode = "404", description = "Superhéroe no encontrado") })
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> deleteSuperhero(@PathVariable Long id) {
		if (superheroService.existsSuperheroById(id)) {
			superheroService.deleteSuperhero(id);
			return ResponseEntity.ok("El superhéroe con ID " + id + " se eliminó con éxito.");
		} else {
			return new ResponseEntity<>("El superhéroe con ID " + id + " no existe", HttpStatus.NOT_FOUND);
		}
	}
}