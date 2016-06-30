package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import com.fundacionjala.apiPivotalTest.Request;
import com.fundacionjala.apiPivotalTest.cucumber.steps.CommonSteps;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CreateProject extends CommonSteps {

    protected Request request;
    protected Response response;

    @Given("^I have set a connection to pivotal_tracker API service$")
    public void iHaveSetAConnectionToPivotal_trackerAPIService()  {
        request = new Request();
    }

    @And("^I have a set of projects$")
    public void iHaveASetOfProjects() {

    }

    @When("^I send a GET request to /projects endpoint$")
    public void iSendAGETRequestToProjectsEndpoint()  {
        response=request.getRequest("/projects");
    }


    public Response getResponse() {
        return response;
    }
}
