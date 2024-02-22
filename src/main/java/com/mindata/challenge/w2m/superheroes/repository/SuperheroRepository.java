package com.mindata.challenge.w2m.superheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindata.challenge.w2m.superheroes.model.Superhero;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

	@Query("SELECT s FROM Superhero s WHERE LOWER(s.name_super) LIKE %:name% OR LOWER(s.name) LIKE %:name%")
	List<Superhero> findByKeywordInNameIgnoreCase(String name);

	List<Superhero> findByNameContaining(String name);
}