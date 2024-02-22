package com.mindata.challenge.w2m.superheroes.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "superheroes", schema = "superheroes_schema")
public class Superhero extends Person {

	@Column(name = "name_super")
	private String name_super;

	@ManyToMany
	@JoinTable(name = "superhero_powers", schema = "superheroes_schema", joinColumns = @JoinColumn(name = "superhero_id"), inverseJoinColumns = @JoinColumn(name = "power_id"))
	private Set<Power> powers = new HashSet<>();

	public Superhero(String name_super, Set<Power> powers) {
		super();
		this.name_super = name_super;
		this.powers = powers;
	}

	public Superhero(String name, String name_super) {
		super(name);
		this.name_super = name_super;
	}

	public Superhero(Long id, String name, String name_super, Set<Power> powers) {
		super(id, name);
		this.name_super = name_super;
		this.powers = powers;
	}

	public Superhero() {
		super();
	}

	public String getName_super() {
		return name_super;
	}

	public void setName_super(String name_super) {
		this.name_super = name_super;
	}

	public Set<Power> getPowers() {
		return powers;
	}

	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}

}
