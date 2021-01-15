package com.upfpo.app.configuration.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class
SwaggerConfiguration {

	private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
            .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
            = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
            new SecurityReference("JWT", authorizationScopes));
    }
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);

	 @Bean
	    public Docket api() { 
//		 return new Docket(DocumentationType.SWAGGER_2)
//			      .apiInfo(getApiInfo())
////			      .securityContexts(Arrays.asList(securityContext()))
////			      .securitySchemes(Arrays.asList(apiKey()))
//			      .select()
//			      .apis(RequestHandlerSelectors.basePackage("com.upfpo.app"))
//			      .paths(PathSelectors.any())
//			      .build(); 
		 
		 
		 
		 log.debug("Starting Swagger");
	        Contact contact = new Contact(
	            "Matyas Albert-Nagy",
	            "https://justrocket.de",
	            "matyas@justrocket.de");

	        List<VendorExtension> vext = new ArrayList<>();
	        ApiInfo apiInfo = new ApiInfo(
	            "Backend API",
	            "This is the best stuff since sliced bread - API",
	            "6.6.6",
	            "https://justrocket.de",
	            contact,
	            "MIT",
	            "https://justrocket.de",
	            vext);

	        Docket docket = new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo)
	            .pathMapping("/")
	            .apiInfo(getApiInfo())
	            .forCodeGeneration(true)
	            .genericModelSubstitutes(ResponseEntity.class)
	            .ignoredParameterTypes(Pageable.class)
	            .ignoredParameterTypes(java.sql.Date.class)
	            .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	            .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
	            .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
	            .securityContexts(Arrays.asList(securityContext()))
	            .securitySchemes(Arrays.asList(apiKey()))
	            .useDefaultResponseMessages(false);

	        docket = docket.select()
	        		.apis(RequestHandlerSelectors.basePackage("com.upfpo.app"))
				      .paths(PathSelectors.any())
	            .build();
//	        watch.stop();
//	        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
	        return docket;
		 
		 
		 
	    }
	    
	    private ApiInfo getApiInfo()
	    {
	    	return new ApiInfo("UPFPO API", "API documentation for UPAGRI Application", "1.0", "For internal use only", new springfox.documentation.service.Contact("xyz", "xyz.com", "nishant.shah@neosoftmail.com"), "API License", "UPAGRI", Collections.emptyList());

	    	
	    }
	
	
}
