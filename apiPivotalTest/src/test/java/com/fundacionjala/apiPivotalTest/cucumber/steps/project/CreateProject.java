package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import com.fundacionjala.apiPivotalTest.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CreateProject {

    protected RequestManager request;
    protected Response response;

    @Given("^I have set a connection to pivotal_tracker API service$")
    public void iHaveSetAConnectionToPivotal_trackerAPIService()  {
        request = new RequestManager();
    }

    @Given("^I have a set of projects$")
    public void iHaveASetOfProjects() {

    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequestToProjectsEndpoint(String endpoint)  {
        response=request.getRequest(endpoint);
    }


    public Response getResponse() {
        return response;
    }
}
