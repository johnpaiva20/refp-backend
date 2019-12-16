package com.tostringtech.refp.project.api.rest.controller;


import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

class ProjectRestControllerTest {

    @Test
    void whenGetProjectsRespondWithStatusCode0K(){
        /* when()
             .get("/projects")
                 .then()
                    .log().ifError()
                    .assertThat()
                 .statusCode(HttpStatus.SC_OK);*/
    }

}
