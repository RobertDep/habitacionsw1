package com.example.RoomConfigService;
// src/main/java/com/example/RoomConfigService/config/WebMvcConfig.java

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
     public void addCorsMappings(CorsRegistry registry) {
    registry
      .addMapping("/api/**")
      .allowedOriginPatterns("*")          // acepta cualquier origen
      .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
      .allowedHeaders("*")
      .allowCredentials(false);            // o true si realmente necesitas cookies
  }

}