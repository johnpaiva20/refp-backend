package com.tostringtech.refp.enterprise.graphql.datafetchers;

import com.tostringtech.refp.enterprise.api.resources.EnterpriseResource;
import com.tostringtech.refp.enterprise.api.service.EnterpriseService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EnterpriseQueryDatafetcher {

    @Autowired
    private EnterpriseService enterpriseService;

    public DataFetcher listEnterprises() {
        return dataFetchingEnvironment -> {
            return enterpriseService.findAll().stream().map(EnterpriseResource::new).collect(Collectors.toList());
        };
    }

    public DataFetcher getEnterprise() {
        return dataFetchingEnvironment -> {
            Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id").toString());
            return enterpriseService.findById(id).map(EnterpriseResource::new);
        };
    }


    public Map<String, DataFetcher> getDataFetcherMap() {

        Map<String, DataFetcher> dataFetcherMap = new HashMap<>();
        dataFetcherMap.put("listEnterprises", listEnterprises());
        dataFetcherMap.put("enterprise", getEnterprise());

        return dataFetcherMap;
    }
}
