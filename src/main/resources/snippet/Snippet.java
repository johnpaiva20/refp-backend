package snippet;

public class Snippet {
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.tostringtech.refp.resources"))
	                .build()
	                .apiInfo(metaData());
	    }
	    private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("Spring Boot REST API")
	                .description("\"Spring Boot REST API for Online Store\"")
	                .version("1.0.0")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	                .contact(new Contact("", "", ""))
	                .build();
	    }
}

