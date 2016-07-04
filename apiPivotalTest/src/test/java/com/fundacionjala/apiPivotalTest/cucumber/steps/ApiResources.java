package com.fundacionjala.apiPivotalTest.cucumber.steps;

import com.fundacionjala.apiPivotalTest.Mapper;
import com.fundacionjala.apiPivotalTest.RequestManager;
import com.jayway.restassured.response.Response;

import org.json.simple.JSONObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.fundacionjala.apiPivotalTest.RequestManager.getRequest;

public class ApiResources {

    private Response response;

    private JSONObject parameters;

    private Map<String, Response> listResponses;

    private String endPoint;

    public ApiResources() {
        listResponses = new HashMap<>();
    }

    @And("^I have the (.*) endpoint$")
    public void iHaveTheEndpoint(String endPoint) {
        this.endPoint = mapEndpoint(endPoint);
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(endPoint);
    }

    @When("^I sen(?:d|t) a (.*) POST request$")
    public void iSendAPOSTRequest(String context) {
        response = RequestManager.postRequest(endPoint, parameters);
    }

    @When("^I send a (.*) DELETE request to (.*?) endpoint$")
    public void iSendADELETERequest(String context, String endPoint) {
        this.endPoint = mapEndpoint(endPoint);
        response = RequestManager.deleteRequest(this.endPoint);
    }

    @When("^I send a (.*) PUT request to (.*) endpoint$")
    public void iSendAPUTRequest(String context, String endPoint) {
        this.endPoint = mapEndpoint(endPoint);
        response = RequestManager.putRequest(this.endPoint, parameters);
    }

    public String mapEndpoint(String endPoint) {
        Matcher matches = Pattern.compile("(?<=\\[)(.*?)(?=\\])").matcher(endPoint);
        StringBuffer newEndPoint = new StringBuffer();
        String replaceParameter = "";
        while (matches.find()) {
            String[] parametersParts = matches.group().split("\\.", 2);
            String parameter = parametersParts[0];
            String field = parametersParts[1];
            replaceParameter = Mapper.getField(listResponses.get(parameter), field);
            matches.appendReplacement(newEndPoint, replaceParameter);
        }
        matches.appendTail(newEndPoint);
        return newEndPoint.toString().replaceAll("[\\[\\]]", "");
    }

    public Response getResponse() {
        return response;
    }

    public void setParameters(JSONObject parameters) {
        this.parameters = parameters;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @When("^I send a story DELETE request$")
    public void iSendAStoryDELETERequest() {
        response = RequestManager.deleteRequest(this.endPoint);
    }

    @And("^stored as (.*)")
    public void storedAsProject(String key) {
        listResponses.put(key, response);
    }
}
