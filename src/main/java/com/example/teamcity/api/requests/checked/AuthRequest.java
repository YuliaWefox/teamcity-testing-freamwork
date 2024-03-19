package com.example.teamcity.api.requests.checked;

import com.example.teamcity.api.spec.Specifications;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class AuthRequest {

    private RequestSpecification spec;
    public AuthRequest(RequestSpecification user) {
this.spec = user;
    }

    public String getCsrfToken() {
        return RestAssured
                .given()
                .spec(spec)
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
    }
}
