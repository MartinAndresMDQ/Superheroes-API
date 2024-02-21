package com.mindata.challenge.w2m.superheroes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "superheroes", schema = "superheroes_schema")
public class Superhero extends Person {

    @Column(name="name_super")
	private String name_super;

	// Otros atributos específicos de Superhero

	@ManyToMany
	@JoinTable(name = "superhero_powers", joinColumns = @JoinColumn(name = "superhero_id"), inverseJoinColumns = @JoinColumn(name = "power_id"))
	private Set<Power> powers = new HashSet<>();

	public Superhero(String name_super, Set<Power> powers) {
		super();
		this.name_super = name_super;
		this.powers = powers;
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
