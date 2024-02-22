package com.mindata.challenge.w2m.superheroes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.repository.SuperheroRepository;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

@Service
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository superheroRepository;

	@Override
    @Cacheable("superheroes")
	public List<Superhero> getAllSuperheroes() {
		return superheroRepository.findAll();
	}

	@Override
	public Optional<Superhero> getSuperheroById(Long id) {
		return superheroRepository.findById(id);
	}

	@Override
	public List<Superhero> getSuperheroesByName(String name) {
		return superheroRepository.findByKeywordInNameIgnoreCase(name.toLowerCase());
	}

	@Override
	public Superhero createSuperhero(Superhero superhero) {
		return superheroRepository.save(superhero);
	}

	@Override
	public Superhero updateSuperhero(Long id, Superhero superhero) {
		superhero.setId(id); // Asegura que el ID del superhéroe sea el mismo que se pasa
		return superheroRepository.save(superhero);
	}

	@Override
	public void deleteSuperhero(Long id) {
		superheroRepository.deleteById(id);
	}
}