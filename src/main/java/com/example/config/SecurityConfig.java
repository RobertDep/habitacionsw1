package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.http.HttpMethod.*;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .cors(Customizer.withDefaults())    // usa tu WebConfig
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth
        .requestMatchers(OPTIONS, "/api/**").permitAll()   // preflight libre
        .anyRequest().authenticated()
      )
      // Si no necesitas autenticación de verdad, coméntalo:
      .httpBasic(Customizer.withDefaults());

    return http.build();
  }
}