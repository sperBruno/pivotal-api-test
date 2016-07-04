package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import com.fundacionjala.apiPivotalTest.cucumber.steps.ApiResources;

import cucumber.api.java.en.And;

import static org.junit.Assert.assertEquals;

public class AssertsProject {

    private ApiResources api;

    public AssertsProject(ApiResources api) {
        this.api = api;
    }

    @And("^The (?:project|story) name should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String expectedProjectName) {
        assertEquals(expectedProjectName, api.getResponse().path("name"));
    }
}
