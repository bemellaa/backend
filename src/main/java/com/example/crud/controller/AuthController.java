package com.example.crud.controller;

import com.example.crud.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // Permite que el Frontend entre sin problemas
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    // Clase auxiliar para recibir los datos del Login (Email y Password)
    public static class LoginRequest {
        public String email;
        public String password;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        try {
            // Intentamos loguear con el EMAIL y la CONTRASEÑA
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email, request.password)
            );

            // Si los datos son correctos, generamos el Token
            if (authentication.isAuthenticated()) {
                return jwtUtil.generateToken(request.email);
            } else {
                throw new RuntimeException("Usuario inválido");
            }
        } catch (Exception e) {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}