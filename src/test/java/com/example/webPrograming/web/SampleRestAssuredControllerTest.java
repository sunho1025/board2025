package com.example.webPrograming.web;

import com.example.webPrograming.domain.Sample;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.util.UriComponentsBuilder;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleRestAssuredControllerTest {
    @LocalServerPort
    int port;

    @BeforeEach
    void setUp(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void testGetUserById(){
        given()
                .pathParam("id",1)
                .when()
                .get("/sample/selectOne?id={id}")
                .then()
                .statusCode(200)
                .body("id",equalTo(1))
                .body("title", equalTo("update1"));
    }
}
