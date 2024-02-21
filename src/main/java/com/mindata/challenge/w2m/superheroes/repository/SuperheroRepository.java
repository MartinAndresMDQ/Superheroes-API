package com.mindata.challenge.w2m.superheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindata.challenge.w2m.superheroes.model.Superhero;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}
