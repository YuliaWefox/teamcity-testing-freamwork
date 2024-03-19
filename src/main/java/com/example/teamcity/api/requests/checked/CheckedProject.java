package com.example.teamcity.api.requests.checked;
import com.example.teamcity.api.models.Project;
import com.example.teamcity.api.requests.Crudinterface;
import com.example.teamcity.api.requests.unchecked.UncheckedProject;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;


public class CheckedProject implements Crudinterface {
private final RequestSpecification spec;
    public CheckedProject(RequestSpecification user) {
this.spec = user;
    }
    @Override
    public Project create(Object obj) {
        return new UncheckedProject(spec).create(obj)
        .then().assertThat().statusCode(HttpStatus.SC_OK)
        .extract().as(Project.class);
    }

    @Override
    public Project get(String id) {
        return new UncheckedProject(spec)
                .get(id).then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);

    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public String delete(String id) {
        return new UncheckedProject(spec)
                .delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT)
                .extract().asString();
    }
}
