package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // <--- ESTA ES LA RUTA CLAVE
@CrossOrigin(origins = "*") // Permite que el Frontend se conecte
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 1. OBTENER TODOS
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. REGISTRAR USUARIO (El que te está fallando)
    @PostMapping
    public User createUser(@RequestBody User user) {
        // Aquí podrías encriptar la contraseña si quisieras, 
        // pero para tu entrega dejémoslo simple para que funcione.
        return userRepository.save(user);
    }

    // 3. ELIMINAR
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}