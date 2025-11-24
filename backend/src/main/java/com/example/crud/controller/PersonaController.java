package com.example.crud.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin("*")
public class PersonaController {
    private final PersonaRepository repo;
    public PersonaController(PersonaRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Persona>listar(){
        return repo.findAll();
    }

    @PostMapping
    public Persona guardar(@RequestBody Persona persona){
        return repo.save(persona);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repo.deleteById(id);
    }
}
