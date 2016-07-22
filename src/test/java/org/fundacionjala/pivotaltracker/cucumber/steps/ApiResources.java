package org.fundacionjala.pivotaltracker.cucumber.steps;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;

import static org.fundacionjala.pivotaltracker.api.Mapper.addResponse;
import static org.fundacionjala.pivotaltracker.api.Mapper.mapEndpoint;
import static org.fundacionjala.pivotaltracker.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotaltracker.api.RequestManager.getRequest;
import static org.fundacionjala.pivotaltracker.api.RequestManager.postRequest;
import static org.fundacionjala.pivotaltracker.api.RequestManager.putRequest;
import static org.junit.Assert.assertEquals;

/**
 * @author Henrry Salinas.
 *         <p>
 *         This class provide the basic step definitions to work with pivotaltracker rest requests
 */
public class ApiResources {

    private Response response;

    private String endPoint;

    private Map <String , Object> MapParameter;

    @Given("^I have the (.*) endpoint$")
    public void iHaveTheEndpoint(String endPoint) {
        this.endPoint = mapEndpoint(endPoint);
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(this.endPoint = mapEndpoint(endPoint));
    }

    @When("^I sen(?:d|t) a POST request to (.*)$")
    public void iSendAPOSTRequestWith(String endPoint, Map<String, Object> parameters) {
        MapParameter = parameters;
        response = postRequest(this.endPoint = mapEndpoint(endPoint), parameters);
    }

    @When("^I send a PUT request to (.*?)$")
    public void iSendAPUTRequest(String endPoint, Map<String, Object> parameters) {
        response = putRequest(this.endPoint = mapEndpoint(endPoint), parameters);
    }

    @When("^I send a DELETE request$")
    public void iSendADELETERequest() {
        response = deleteRequest(endPoint);
    }

    @And("^stored as (.*)")
    public void storedAs(String key) {
        addResponse(key, response);
    }

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, response.statusCode());
    }

    public Response getResponse() {
        return response;
    }

    public String getEndPoint() {
        return endPoint;
    }

}
