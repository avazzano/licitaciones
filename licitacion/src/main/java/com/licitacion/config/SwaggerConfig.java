package com.licitacion.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.ApiListingReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// @Value("${info.build.version}")
	private String version = "0.1";

	private String env = "Desarrollo"; // AppProperties.getAmbiente();

	@Bean
    public Docket postsApi() {
    	
        //Adding Header
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("Authorization")                 // name of header
                         .modelRef(new ModelRef("string"))
                         .parameterType("header")               // type - header
                         .defaultValue("Basic em9uZTpteXBhc3N3b3Jk")        // based64 of - zone:mypassword
                         .required(true)                // for compulsory
                         .build();
        List<springfox.documentation.service.Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());             // add parameter
    	
    	
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                //.securitySchemes(Arrays.asList(apiKey()))
                .select()
                .paths(postPaths())
                .build()
                .apiListingReferenceOrdering(new Ordering<ApiListingReference>() {
                    @Override
                    public int compare(ApiListingReference left, ApiListingReference right) {
                        return left.getPosition()>=right.getPosition()?-1:1;
                    }
                });
             //   .globalOperationParameters(aParameters);
    }

	private Predicate<String> postPaths() {
		return or(regex("/api/licitaciones.*"), regex("/api/vehiculos.*"), regex("/api/ofertas.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Licitacion API (" + env + ")").description("v " + version)
				.termsOfServiceUrl("http://")
				// .contact("avazzano2segurosrivadavia.com").license("Apache License")
				.version(version).build();
	}

	private ApiKey apiKey() {
		return new ApiKey("authkey", "Authorization", "header");
	}

	


}