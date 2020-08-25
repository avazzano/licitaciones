package com.licitacion.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiListingReference;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// @Value("${info.build.version}")
	private String version = "0.1";

	private String env = "Desarrollo"; // AppProperties.getAmbiente();

	@Bean
	public Docket postsApi() {

		// Adding Header
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization") // name of header
				.modelRef(new ModelRef("string")).parameterType("header") // type - header
				// .defaultValue("Basic em9uZTpteXBhc3N3b3Jk") // based64 of - zone:mypassword
				.required(false) // for compulsory
				.build();
		
		List<springfox.documentation.service.Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder.build()); // add parameter

		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").
					apiInfo(apiInfo())
					.select()
					.paths(postPaths()).
					build()
					.securityContexts(Arrays.asList(securityContext()))
					.securitySchemes(Collections.singletonList(securitySchema()))
					 
					.apiListingReferenceOrdering(new Ordering<ApiListingReference>() {
						@Override
						public int compare(ApiListingReference left, ApiListingReference right) {
							return left.getPosition() >= right.getPosition() ? -1 : 1;
						}
				     })
				    .globalOperationParameters(aParameters);
	}

	/**
	 * 
	 * @return
	 */
	private Predicate<String> postPaths() {
		return or(regex("/api/licitaciones.*"), regex("/api/vehiculos.*"), regex("/api/ofertas.*"),
				regex("/api/persona.*"));
	}
	
	private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .forPaths(PathSelectors.ant("/api/v1/**"))
                .build();
    }

	 private SecurityReference basicAuthReference() {
	        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
	    }
	/**
	 * 
	 * @return
	 */
	private OAuth securitySchema() {

		List<AuthorizationScope> authorizationScopeList = new ArrayList();
		authorizationScopeList.add(new AuthorizationScope("read", "read all"));
		authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
		authorizationScopeList.add(new AuthorizationScope("write", "access all"));

		List<GrantType> grantTypes = new ArrayList();
		GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant("/oauth/token");

		grantTypes.add(creGrant);

		return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

	}

	/**
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Licitacion API (" + env + ")").description("v " + version)
				.termsOfServiceUrl("http://")
				// .contact("avazzano2segurosrivadavia.com").license("Apache License")
				.version(version).build();
	}

	/**
	 * 
	 * @return
	 */
	private List<SecurityReference> defaultAuth() {

		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
		authorizationScopes[0] = new AuthorizationScope("read", "read all");
		authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
		authorizationScopes[2] = new AuthorizationScope("write", "write all");

		return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
	}

}