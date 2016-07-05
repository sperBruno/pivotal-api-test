package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import java.util.Map;

import com.fundacionjala.apiPivotalTest.cucumber.steps.ApiResources;

import org.json.simple.JSONObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Project {

    private JSONObject parameters;

    private ApiResources api;

    public Project(ApiResources api) {
        this.api = api;
    }

    @Given("^I have set a connection to pivotal tracker API service$")
    public void iHaveSetAConnectionToPivotalTrackerAPIService() {
    }

    @Given("^I have a set of projects$")
    public void iHaveASetOfProjects() {
    }

    @Given("^I have the next parameters:$")
    public void iHaveTheNextParametersToCreateAProject(Map<String, Object> parameters) {
        api.setParameters(parameters);
    }

    @Given("^I have a project created$")
    public void iHaveAProjectCreated() {
    }

    @And("^I have (.*) as a new project name$")
    public void iHaveANewProjectName(String newProjectName) {
        parameters.put("name", newProjectName);
        api.setParameters(parameters);
    }
}
