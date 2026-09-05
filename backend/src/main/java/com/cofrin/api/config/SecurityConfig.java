package com.cofrin.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desliga o CSRF: proteção pensada para apps com sessão/formulário.
                // Nossa API vai ser stateless (via token), então não se aplica.
                .csrf(csrf -> csrf.disable())
                // define as regras de autorização das rotas
                .authorizeHttpRequests(auth -> auth
                        // libera geral por enquanto - vamos apertar na Fase B (Login/JWT)
                        .anyRequest().permitAll());

        return http.build();
    }

}
