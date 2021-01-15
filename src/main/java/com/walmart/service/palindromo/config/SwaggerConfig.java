package com.walmart.service.palindromo.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @Autowired
    private BuildProperties buildProperties;
    
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.walmart.service.palindromo"))
		.paths(PathSelectors.any()).build()
		.apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("Palindromo Service")
                .description("Palindromo service")
		        .version(buildProperties.getVersion() + " - build date: " + buildProperties.getTime())
		        .termsOfServiceUrl("Terms of service")
		        .license("Copyright (c) " + LocalDate.now().getYear() + " by Walmart")
                .contact(new Contact("Palindromo Web", "contactURL", "vparra@gmail.com"))
                .build();
	}
}
