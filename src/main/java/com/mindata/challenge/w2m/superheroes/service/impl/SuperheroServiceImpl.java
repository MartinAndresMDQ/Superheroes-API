package com.mindata.challenge.w2m.superheroes.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindata.challenge.w2m.superheroes.model.Power;
import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.repository.PowerRepository;
import com.mindata.challenge.w2m.superheroes.repository.SuperheroRepository;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

@Service
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository superheroRepository;

	@Autowired
	private PowerRepository powerRepository;

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
	@CacheEvict(value = "superheroes", allEntries = true)
	public Superhero createSuperhero(Superhero superhero) {
		if (superhero.getPowers() != null) {
			Set<Power> powers = superhero.getPowers().stream().map(powerRepository::save).collect(Collectors.toSet());
			superhero.setPowers(powers);
		}
		return superheroRepository.save(superhero);
	}

	@Override
	@CacheEvict(value = "superheroes", allEntries = true)
	public Superhero updateSuperhero(Long id, Superhero superhero) {
		Superhero superh = null;
		if (existsSuperheroById(id)) {
			superhero.setId(id); // Asegura que el ID del superhéroe sea el mismo que se pasa
			if (superhero.getPowers() != null) {
				Set<Power> powers = superhero.getPowers().stream().map(powerRepository::save)
						.collect(Collectors.toSet());
				superhero.setPowers(powers);
			}
			superh = superheroRepository.save(superhero);

		}
		return superh;

	}

	@Override
	@CacheEvict(value = "superheroes", allEntries = true)
	public void deleteSuperhero(Long id) {
		superheroRepository.deleteById(id);
	}

	@Override
	public boolean existsSuperheroById(Long id) {
		return superheroRepository.existsById(id);
	}
}