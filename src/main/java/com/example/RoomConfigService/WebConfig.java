package com.example.RoomConfigService;
// src/main/java/com/example/RoomConfigService/config/WebMvcConfig.java

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
          .addMapping("/api/**")
          .allowedOriginPatterns("*")        // durante desarrollo puedes usar "*" o tu dominio
          .allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
          .allowedHeaders("*")
          .allowCredentials(false);
    }
}