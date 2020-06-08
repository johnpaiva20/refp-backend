package com.tostringtech.refp.project.api.rest.controller;


import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ProjectRestControllerTest {

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
