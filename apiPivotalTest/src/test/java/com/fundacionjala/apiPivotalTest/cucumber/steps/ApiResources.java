package com.fundacionjala.apiPivotalTest.cucumber.steps;

import java.util.HashMap;
import java.util.Map;

import com.fundacionjala.apiPivotalTest.RequestManager;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.fundacionjala.apiPivotalTest.Mapper.mapEndpoint;
import static com.fundacionjala.apiPivotalTest.RequestManager.getRequest;
import static org.junit.Assert.assertEquals;

public class ApiResources {

    private Response response;

    private Map<String, Object> parameters;

    private Map<String, Response> listResponses;

    private String endPoint;

    public ApiResources() {
        listResponses = new HashMap<>();
    }

    @And("^I have the (.*) endpoint$")
    public void iHaveTheEndpoint(String endPoint) {
        this.endPoint = mapEndpoint(endPoint, listResponses);
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(endPoint);
    }

    @When("^I sen(?:d|t) a POST request$")
    public void iSendAPOSTRequest() {
        response = RequestManager.postRequest(endPoint, parameters);
    }

    @When("^I send a DELETE request to (.*?) endpoint$")
    public void iSendADELETERequest(String endPoint) {
        response = RequestManager.deleteRequest(mapEndpoint(endPoint, listResponses));
    }

    @When("^I send a PUT request to (.*) endpoint$")
    public void iSendAPUTRequest(String endPoint) {
        response = RequestManager.putRequest(mapEndpoint(endPoint, listResponses), parameters);
    }

    @And("^stored as (.*)")
    public void storedAsProject(String key) {
        listResponses.put(key, response);
    }

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, response.statusCode());
    }

    public Response getResponse() {
        return response;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getEndPoint() {
        return endPoint;
    }

}
