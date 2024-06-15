package com.app.etudiantappservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI registrationOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Student Service - SpringBoot REST API Service")
                        .description("This is an API specification for student Service \n" +
                                "    written in SpringBoot")
                        .version("1.0"));
    }
}