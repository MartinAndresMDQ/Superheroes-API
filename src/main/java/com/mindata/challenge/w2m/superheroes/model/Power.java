package com.mindata.challenge.w2m.superheroes.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "powers", schema = "superheroes_schema")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @ManyToMany(mappedBy = "powers")
    private Set<Superhero> superheroes = new HashSet<>();

    
	public Power() {
	}
	

	public Power(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public Power(Long id, String name, Set<Superhero> superheroes) {
		super();
		this.id = id;
		this.name = name;
		this.superheroes = superheroes;
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
    
    // Constructores, getters y setters
    
}
