package com.example.restservicecors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
	public static final String[] ALLOWED_ORIGINS = {
		"http://localhost:4200",
		"http://test.com",
		"https://fids.paas.ups.com"
};
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // registry.addMapping("/**");
                registry.addMapping("/greeting-javaconfig").allowedOrigins(ALLOWED_ORIGINS).allowedMethods("GET");
				registry.addMapping("/process").allowedOrigins(ALLOWED_ORIGINS).allowedMethods("POST");
            }
        };
    }
}