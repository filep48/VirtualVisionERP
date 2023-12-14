package com.virtualvision.erp.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.virtualvision.erp.service.security.SecurityDetails;

@Configuration // Indica al sistema que és una classe de configuració
@EnableWebSecurity // Habilita la seguretat web
public class AuthConfig {

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

    @Autowired
    private SecurityDetails securityDetails;

    @Autowired
    public void authentication(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(securityDetails).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // Permitir acceso a recursos
                                                                                        // estáticos
                        .requestMatchers("/templates/**").permitAll() // Permitir acceso a la página de inicio

                        .requestMatchers("/customer/**").permitAll()
                        .requestMatchers("/customers/**").permitAll()
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/dashboard/**").permitAll()
                        .requestMatchers("/employee/**").permitAll()
                        .requestMatchers("/rrhh/**").permitAll()
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers("/sale/**").permitAll()
                        )
                .formLogin((form) -> form
                        .loginPage("/login").permitAll() // Permitir a todos el acceso al formulario de login
                        .defaultSuccessUrl("/dashboard", true) // Redirigir a /home después de un inicio de sesión
                                                               // exitoso
                        .permitAll())
                .build(); // Cierra la configuración y construye el SecurityFilterChain
    }

}