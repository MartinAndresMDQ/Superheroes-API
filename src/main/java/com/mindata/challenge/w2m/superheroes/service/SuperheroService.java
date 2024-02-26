package com.mindata.challenge.w2m.superheroes.service;

import java.util.List;
import java.util.Optional;

import com.mindata.challenge.w2m.superheroes.model.Superhero;

public interface SuperheroService {
	List<Superhero> getAllSuperheroes();

	Optional<Superhero> getSuperheroById(Long id);

	List<Superhero> getSuperheroesByName(String name);

	Superhero createSuperhero(Superhero superhero);

	Superhero updateSuperhero(Long id, Superhero superhero);

	void deleteSuperhero(Long id);

	boolean existsSuperheroById(Long id);
}