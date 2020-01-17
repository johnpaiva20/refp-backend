package com.tostringtech.refp.project.api.rest.controller;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ProjectRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetProjectsRespondWithStatusCode0K(){

        given().when()
             .get("/projects")
                 .then()
                    .log().ifError()
                    .assertThat()
                 .statusCode(HttpStatus.SC_OK);
    }

}
