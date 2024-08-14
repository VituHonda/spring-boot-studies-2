package br.com.fiap.produtomvc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition
@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAPI apiProdutos() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Cadastro de Produtos")
                        .description("Projeto de Referência - API Produtos")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("google.com")));

    }

}
