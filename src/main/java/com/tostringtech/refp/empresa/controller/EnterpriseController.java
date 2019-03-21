package com.tostringtech.refp.empresa.controller;

import com.tostringtech.refp.empresa.service.EmpresaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enterprises")
@Api(tags = "Enterprise")
public class EnterpriseController {

    @Autowired
    private EmpresaService empresaService;
    
}
