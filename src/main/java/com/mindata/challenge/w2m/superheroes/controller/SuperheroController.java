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

import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Superhero> getAllSuperheroes() {
		List<Superhero> lista = superheroService.getAllSuperheroes();
		return lista;
	}

	@GetMapping("/{id}")
	public Superhero getSuperheroById(@PathVariable Long id) {
		Optional<Superhero> opt = superheroService.getSuperheroById(id);
		return opt.orElseThrow(() -> new RuntimeException("Superhero not found with id: " + id));
	}

	@GetMapping("/search")
	public List<Superhero> getSuperheroesByName(@RequestParam String name) {
		return superheroService.getSuperheroesByName(name);
	}

	@PostMapping
	public Superhero createSuperhero(@RequestBody Superhero superhero) {
		return superheroService.createSuperhero(superhero);
	}

	@PutMapping("/{id}")
	public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero superhero) {
		return superheroService.updateSuperhero(id, superhero);
	}

	@DeleteMapping("/{id}")
	public void deleteSuperhero(@PathVariable Long id) {
		superheroService.deleteSuperhero(id);
	}
}