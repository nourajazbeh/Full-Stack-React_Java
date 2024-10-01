package com.example.my_spring_boot_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF-Schutz deaktivieren
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/public/**").permitAll() // öffentlichen Zugriff
                .anyRequest().authenticated() // Authentifizierung
            )
            .formLogin(form -> form // Formularanmeldung konfigurieren
                .loginPage("/login") // Benutzerdefinierte Login-Seite
                .permitAll() // Zugriff auf die Login-Seite
            );

        return http.build();
    }
}
