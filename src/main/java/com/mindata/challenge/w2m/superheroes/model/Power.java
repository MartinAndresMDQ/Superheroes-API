package com.mindata.challenge.w2m.superheroes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
    
    // Constructores, getters y setters
}
