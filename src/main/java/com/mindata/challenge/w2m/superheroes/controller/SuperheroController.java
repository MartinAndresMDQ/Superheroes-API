package com.mindata.challenge.w2m.superheroes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindata.challenge.w2m.superheroes.annotation.ExecutionTime;
import com.mindata.challenge.w2m.superheroes.model.Superhero;
import com.mindata.challenge.w2m.superheroes.service.SuperheroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@PropertySource("mensajes.properties")
@RequestMapping("/api/superheroes")
@Tag(name  = "ControladorSuperheroes", description = "${application.json.value}")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @ExecutionTime
    @Operation(summary = "${operation.get_all_superheroes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${response.get_all_superheroes}")
    })
    @GetMapping(value = "/todos", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Superhero> getAllSuperheroes() {
        return superheroService.getAllSuperheroes();
    }

    @ExecutionTime
    @Operation(summary = "${operation.get_superhero_by_id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${response.get_superhero_by_id}")
    })
    @GetMapping(value = "/traer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Superhero getSuperheroById(@PathVariable Long id) {
        Optional<Superhero> opt = superheroService.getSuperheroById(id);
        return opt.orElseThrow(() -> new RuntimeException("${exception.superhero_not_found} " + id));
    }

    @ExecutionTime
    @Operation(summary = "${operation.get_superheroes_by_name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${response.get_superheroes_by_name}")
    })
    @GetMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Superhero> getSuperheroesByName(@RequestParam String nombre) {
        return superheroService.getSuperheroesByName(nombre);
    }

    @ExecutionTime
    @Operation(summary = "${operation.create_superhero}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${response.create_superhero}")
    })
    @PostMapping(value = "/crear", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public Superhero createSuperhero(@RequestBody Superhero superheroe) {
        return superheroService.createSuperhero(superheroe);
    }

    @ExecutionTime
    @Operation(summary = "${operation.update_superhero}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${response.update_superhero}")
    })
    @PutMapping("/actualizar/{id}")
    public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero superheroe) {
        return superheroService.updateSuperhero(id, superheroe);
    }

    @ExecutionTime
    @Operation(summary = "${operation.delete_superhero}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${response.delete_superhero}")
    })
    @DeleteMapping("/borrar/{id}")
    public void deleteSuperhero(@PathVariable Long id) {
        superheroService.deleteSuperhero(id);
    }
}
