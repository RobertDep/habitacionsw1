package com.example.config;
// src/main/java/com/example/RoomConfigService/config/SecurityConfig.java

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .cors(Customizer.withDefaults())   // usa tu WebConfig
      .csrf(csrf -> csrf.disable())      // desactiva CSRF (no tienes formularios aquí)
      .authorizeHttpRequests(auth -> auth
          .anyRequest().permitAll()      // permite TODO sin auth
      );
    return http.build();
  }
}
