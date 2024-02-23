package com.mindata.challenge.w2m.superheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindata.challenge.w2m.superheroes.model.Power;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {
}