package com.fundacionjala.apiPivotalTest.cucumber.steps.project;


import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class AssertsProject {
    private CreateProject createProject;

    public AssertsProject(CreateProject createProject){
        this.createProject=createProject;
    }
    @Then("^I expect status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected)  {
        System.out.println(statusCodeExpected);

        assertEquals(statusCodeExpected, createProject.getResponse().statusCode());
    }
}
