package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import cucumber.api.java.en.And;

import static org.junit.Assert.assertEquals;

public class AssertsProject {

    private Project project;

    public AssertsProject(Project project) {
        this.project = project;
    }

    @And("^The project name should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String expectedProjectName) {
        assertEquals(expectedProjectName, project.getResponse().path("name"));
    }
}
