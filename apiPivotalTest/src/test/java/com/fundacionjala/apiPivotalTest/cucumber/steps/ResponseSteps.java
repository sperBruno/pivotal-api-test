package com.fundacionjala.apiPivotalTest.cucumber.steps;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ResponseSteps {

    private RequestSteps requestSteps;

    public ResponseSteps(RequestSteps requestSteps) {
        this.requestSteps = requestSteps;
    }

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, requestSteps.getResponse().statusCode());
    }
}
