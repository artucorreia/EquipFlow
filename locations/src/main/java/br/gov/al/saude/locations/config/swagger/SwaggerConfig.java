package br.gov.al.saude.locations.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components()
            .addSecuritySchemes("bearerAuth",
                new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")))
        .info(new Info()
            .title("Locations Microservice")
            .description("Microservice to manager SESAU annexes and sectors")
            .version("1.0.0")
            .contact(new Contact()
                .name("Arthur Correia")
                .email("arthurcorreia.dev@gmail.com")
                .url("https://portfolio-artu.web.app/")));
    // .license(new License()
    // .name("Licença da API")
    // .url("https://suaapi.com/licenca")));
  }
}
