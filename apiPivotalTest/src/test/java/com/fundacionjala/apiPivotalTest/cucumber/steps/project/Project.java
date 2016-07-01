package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import java.util.Map;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.json.simple.JSONObject;

public class Project {

    private Response response;

    JSONObject parameters;

    @Given("^I have set a connection to pivotal tracker API service$")
    public void iHaveSetAConnectionToPivotalTrackerAPIService() {
    }

    @Given("^I have a set of projects$")
    public void iHaveASetOfProjects() {

    }

    @Given("^I have the next parameters to create a project:$")
    public void iHaveTheNextParametersToCreateAProject(Map<String, Object> parameters) {
        this.parameters = new JSONObject();
        this.parameters.put("name", parameters.get("name"));
        this.parameters.put("public", new Boolean(parameters.get("public").toString()));
    }

    public JSONObject getParameters() {
        return parameters;
    }

    @Given("^I have a project created$")
    public void iHaveAProjectCreated() {
        int idProjectToDelete = response.getBody().path("id");
        parameters.clear();
        parameters.put("id", idProjectToDelete);
    }

    @And("^I have (.*) as a new project name$")
    public void iHaveANewProjectName(String newProjectName) throws Throwable {

        parameters.put("name", newProjectName);
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }


}
