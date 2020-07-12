package com.albot.contentorchestrationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.albot"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    } //end docket api

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Content Orchestration Microservice API.")
                .description("These are endpoints for content orchestration service.")
                .version("v1.0")
                .build();
    }
}
