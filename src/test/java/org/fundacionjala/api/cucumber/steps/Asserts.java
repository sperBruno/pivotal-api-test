package org.fundacionjala.api.cucumber.steps;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.internal.http.ContentEncoding;
import com.jayway.restassured.mapper.ObjectMapper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.fundacionjala.api.ProjectSteps;
import org.fundacionjala.api.ValidateProjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Asserts {

    private ApiResources api;

    public Asserts(ApiResources api) {
        this.api = api;
    }

    @And("^The (.*?) field should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String fieldName, String expectedValue) {
        assertEquals(expectedValue, api.getResponse().path(fieldName));
    }

    @And("^I validate all setting projects$")
    public void iValidateAllSettingProjects(Map<ProjectSteps, Object> valuesMap) {

        Gson gson = new Gson();
        Map<ProjectSteps,Object> map = new HashMap<>();
        map = (Map<ProjectSteps,Object>) gson.fromJson(api.getResponse().print(), map.getClass());
        Map<ProjectSteps, Object> finalMap = map;
        ValidateProjects.getAssertionMap(finalMap).values().stream().forEach((steps) -> {
            assertTrue("The fields is false ",steps);
        });


    }
}
