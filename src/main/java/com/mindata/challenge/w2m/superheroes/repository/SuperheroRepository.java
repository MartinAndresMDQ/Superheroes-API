package com.mindata.challenge.w2m.superheroes.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindata.challenge.w2m.superheroes.model.Superhero;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    List<Superhero> findByNameContaining(String name);
}