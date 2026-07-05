package com.test.gestionTareas.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/api/**") //Endpoint que inicien con /api
                        .allowCredentials(true)
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST","PUT","PATCH","DELETE","OPTIONS")
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }
}
