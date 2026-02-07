package com.athar.aiassistant.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI Study Assistant API")
                        .description("Backend APIs for AI-powered study and interview preparation")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Athar")
                                .email("athar@example.com")
                        )
                );
    }
}