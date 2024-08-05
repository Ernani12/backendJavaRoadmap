package com.example.demo.coors;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry  registry ) {
        registry.addMapping("/**")
       // registry.addMapping("/api/**")
        .allowedOrigins("http://localhost:5173") // Permitir apenas o Angular
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS",  "HEAD", "TRACE", "CONNECT") // Métodos permitidos
        .allowedHeaders("*") // Headers permitidos
        .allowCredentials(true) // Permitir credenciais (cookies)
        .maxAge(3600);

    }
}