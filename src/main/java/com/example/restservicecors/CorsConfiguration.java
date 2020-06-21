package com.example.restservicecors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins(Constants.ALLOWED_ORIGINS).allowedMethods("GET");
				registry.addMapping("/process").allowedOrigins(Constants.ALLOWED_ORIGINS).allowedMethods("POST");
            }
        };
    }
}