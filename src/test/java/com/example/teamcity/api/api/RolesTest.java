package com.example.teamcity.api.api;

import com.example.teamcity.api.requests.unchecked.UncheckedProject;
import com.example.teamcity.api.spec.Specifications;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RolesTest extends BaseApiTest{
    @Test
    public void unauthorizedUser() {
        new UncheckedProject(Specifications.getSpec().unauthSpec())
                .create(testData.getProject())
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body(Matchers.containsString("Authentication required"));
    }
}
