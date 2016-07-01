package com.fundacionjala.apiPivotalTest.cucumber.steps;

import com.fundacionjala.apiPivotalTest.RequestManager;
import com.fundacionjala.apiPivotalTest.cucumber.steps.project.Project;
import com.fundacionjala.apiPivotalTest.cucumber.steps.stories.Story;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.When;

import static com.fundacionjala.apiPivotalTest.RequestManager.getRequest;

public class RequestSteps {



    private Response response;

    private Project project;

    private Story story;

    public RequestSteps(Project project, Story story) {
        this.project = project;
        this.story=story;
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(endPoint);
    }

    @When("^I send a (.*) POST request$")
    public void iSendAPOSTRequest(String context) {
        if("project".equalsIgnoreCase(context)){
            response = RequestManager.postRequest(project.getProjectEndPoint(), project.getParameters());
            this.project.setResponse(response);
        }else if("story".equalsIgnoreCase(context)){
            response=RequestManager.postRequest(story.getStoryEndpoint(),story.getParameters());
        }

    }

    @When("^I send a (.*) DELETE request to (.*?) endpoint$")
    public void iSendADELETERequest(String context,String endPoint) {
        if("project".equalsIgnoreCase(context)) {
            String deleteEndPoint = new StringBuilder().append(endPoint)
                    .append("/")
                    .append(this.project.getParameters().get("id")).toString();
            response = RequestManager.deleteRequest(deleteEndPoint);
        }else if("story".equalsIgnoreCase(context)){

        }

    }


    @When("^I send a (.*) PUT request to (.*) endpoint$")
    public void iSendAPUTRequest(String context,String endPoint) {
        if("project".equalsIgnoreCase(context)) {
            String updateEndPoint = new StringBuilder().append(endPoint)
                    .append("/")
                    .append(this.project.getParameters().get("id")).toString();
            response = RequestManager.putRequest(updateEndPoint, project.getParameters());
            project.setResponse(response);
        }
        else if("story".equalsIgnoreCase(context)){

        }
    }
    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }
}
