package br.com.correios.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
        .group("public-api")
        .packagesToScan("br.com.correios")
        .addOpenApiCustomiser(openApi -> {
            openApi.info(new Info().title("Consulta de CEP API").version("1.0").description("Documentação da API de Consulta de CEP."));
        })
        .build();
  }
}
