package com.virtualvision.erp.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica al sistema que és una classe de configuració
@EnableWebSecurity // Habilita la seguretat web
public class AuthConfig {
    @Autowired
    private UserDetailsService userDetailsService; // Objecte per recuperar l'usuari

    // crea un contructor
    public AuthConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /* AUTORITZACIÓ */
    /*
     * Utilitzem el mètode filterChain per configurar l'accés dels nostre usuaris a
     * l'aplicació, segons
     * els seus rols, el que s'anomena autoritzar.
     * Passem com a paràmetre un objecte de la classe HttpSecurity de Spring
     * Security que
     * és el que ens permetrà cridar als mètodes per configurar les restriccions
     * d'accés a la nostra aplicació.
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // Permitir acceso a recursos
                                                                                        // estáticos
                        .requestMatchers("/customer/**").permitAll() // URL de ejemplo accesible sin autenticación
                )
                .formLogin((form) -> form
                        .loginPage("/login").permitAll() // Permitir a todos el acceso al formulario de login
                        .defaultSuccessUrl("/home", true) // Redirigir a /home después de un inicio de sesión exitoso
                        .permitAll())
                .build(); // Cierra la configuración y construye el SecurityFilterChain
    }

}