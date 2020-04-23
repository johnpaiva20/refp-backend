package com.tostringtech.refp.application.providers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.tostringtech.refp.application.scalars.DateScalar;
import com.tostringtech.refp.enterprise.graphql.datafetchers.EnterpriseMutationDatafetcher;
import com.tostringtech.refp.enterprise.graphql.datafetchers.EnterpriseQueryDatafetcher;
import com.tostringtech.refp.project.graphql.datafetchers.ProjectMutationDatafetcher;
import com.tostringtech.refp.project.graphql.datafetchers.ProjectQueryDatafetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private ProjectQueryDatafetcher projectQueryDatafetcher;

    @Autowired
    private ProjectMutationDatafetcher projectMutationDatafetcher;

    @Autowired
    private EnterpriseQueryDatafetcher enterpriseQueryDatafetcher;

    @Autowired
    private EnterpriseMutationDatafetcher enterpriseMutationDatafetcher;


    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        GraphQLSchema graphQLSchema = buildSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema() throws IOException {

        SchemaParser schemaParser = new SchemaParser();

        TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

        URL autheticationUrl = Resources.getResource("schemas/project.graphql");
        String autheticationSd = Resources.toString(autheticationUrl, Charsets.UTF_8);
        typeRegistry.merge(schemaParser.parse(autheticationSd));


        URL enterpriseUrl = Resources.getResource("schemas/enterprise.graphql");
        String enterpiseSd = Resources.toString(enterpriseUrl, Charsets.UTF_8);
        typeRegistry.merge(schemaParser.parse(enterpiseSd));

        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .scalar(DateScalar.DATE)
                .type(newTypeWiring("Query")
                        .dataFetchers(projectQueryDatafetcher.getDataFetcherMap()))
                .type(newTypeWiring("Query")
                        .dataFetchers(enterpriseQueryDatafetcher.getDataFetcherMap()))
                .type(newTypeWiring("Mutation")
                        .dataFetchers(projectMutationDatafetcher.getDataFetcherMap()))
                .build();
    }

}
