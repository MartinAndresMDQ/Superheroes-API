package com.mindata.challenge.w2m.superheroes.controller;

import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@GetMapping
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
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