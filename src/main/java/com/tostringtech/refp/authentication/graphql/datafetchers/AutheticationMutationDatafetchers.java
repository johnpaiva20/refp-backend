package com.tostringtech.refp.authentication.graphql.datafetchers;


import org.springframework.stereotype.Component;

@Component
public class AutheticationMutationDatafetchers {

   /* @Autowired
    private AutheticationService autheticatioService;

    public DataFetcher authentication() {
        return dataFetchingEnvironment -> {

            LinkedHashMap credentialInput = dataFetchingEnvironment.getArgument("credentials");

            CredentialResource credentials = new CredentialResource();
            credentials.setEnrollment(credentialInput.get("enrollment").toString());
            credentials.setPassword(credentialInput.get("password").toString());


            return autheticatioService.authentication(credentials);
        };
    }

    public DataFetcher authenticated() {
        return dataFetchingEnvironment -> {
            String cookie = dataFetchingEnvironment.getArgument("cookie");
            return autheticatioService.authenticated(cookie);
        };
    }*/

}
