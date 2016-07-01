package com.fundacionjala.apiPivotalTest.cucumber.steps;

import com.fundacionjala.apiPivotalTest.RequestManager;
import com.fundacionjala.apiPivotalTest.cucumber.steps.project.Project;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.When;

import static com.fundacionjala.apiPivotalTest.RequestManager.getRequest;

public class RequestSteps {



    private Response response;

    private Project project;

    public RequestSteps(Project project) {
        this.project = project;
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(endPoint);
    }

    @When("^I send a POST request to (.*) endpoint$")
    public void iSendAPOSTRequest(String endPoint) {
        response = RequestManager.postRequest(endPoint, this.project.getParameters());
        this.project.setResponse(response);

    }

    @When("^I send a project DELETE request to (.*?) endpoint$")
    public void iSendADELETERequest(String endPoint) {
        String deleteEndPoint = new StringBuilder().append(endPoint)
                .append("/")
                .append(this.project.getParameters().get("id")).toString();
        response = RequestManager.deleteRequest(deleteEndPoint);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }


    @When("^I send a PUT request to (.*) endpoint$")
    public void iSendAPUTRequest(String endPoint) {
        String updateEndPoint = new StringBuilder().append(endPoint)
                .append("/")
                .append(this.project.getParameters().get("id")).toString();
        response = RequestManager.putRequest(updateEndPoint, project.getParameters());
        project.setResponse(response);
    }
    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }
}
