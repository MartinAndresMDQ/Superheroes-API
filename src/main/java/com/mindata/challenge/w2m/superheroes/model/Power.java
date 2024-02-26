package com.mindata.challenge.w2m.superheroes.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "powers", schema = "superheroes_schema")
public class Power {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "powers")
	@Transient
	@JsonIgnore
	private Set<Superhero> superheroes = new HashSet<>();

	public Power() {
	}

	public Power(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Superhero> getSuperheroes() {
		return superheroes;
	}

	public void setSuperheroes(Set<Superhero> superheroes) {
		this.superheroes = superheroes;
	}

}
