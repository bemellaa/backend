package com.example.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permitir todas las URLs
                        .allowedOrigins("http://localhost:3000") // Solo permitir a tu React
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Verbos permitidos
                        .allowedHeaders("*");
            }
        };
    }
}