package com.testswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Swagger測試")
                        .version("1.0")
                        .description("DEMO用")
                        .contact(new Contact()
                                .name("xxx")
                                .email("xxx@gmail.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("開發環境")
                ));
    }
}
