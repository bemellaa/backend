package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Crear un usuario (Para registro o admin)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/login")
    public User login(@RequestBody User credentials) {
        // Buscamos al usuario por su email
        User user = userRepository.findByEmail(credentials.getEmail());

        // Si existe Y la contraseña coincide
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            return user; // Devolvemos el usuario completo (con nombre y rol)
        }
        return null; // Si falla, devolvemos nulo
    }
}