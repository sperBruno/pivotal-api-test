package org.fundacionjala.pivotal.api;

import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.given;
import static org.fundacionjala.pivotal.api.Authentication.getInstance;

/**
 * The purpose of this class is to provide methods that manage the API REST
 * requests like GET, POST, PUT, and DELETE.
 *
 * @author Henrry Salinas.
 */
public class RequestManager {

    private static final Logger LOGGER = Logger.getLogger(RequestManager.class.getName());

    private static RequestSpecification request = getInstance().getRequestSpecification();

    private RequestManager() {
    }

    /**
     * This method do the GET request with an ENDPOINT
     * to API of pivotal tracker
     *
     * @param endpoint
     * @return response from GET request
     */
    public static Response getRequest(String endpoint) {
        LOGGER.info("GET endpoint is: " + endpoint);
        return given().spec(request)
                .when().get(endpoint);
    }

    /**
     * This method do the POST request with an ENDPOINT
     * and PARAMETERS required
     * to API of pivotal tracker
     *
     * @param endpoint
     * @param parameters
     * @return response from POST request
     */
    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        LOGGER.info("POST endpoint is: " + endpoint);
        return given().spec(request).params(parameters)
                .when().post(endpoint);
    }

    /**
     * This method do the PUT request with an ENDPOINT
     * and PARAMETERS required
     * to API of pivotal tracker
     *
     * @param endpoint
     * @param parameters
     * @return response from PUT request
     */
    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        LOGGER.info("PUT endpoint is: " + endpoint);
        return given().spec(request).params(parameters)
                .when().put(endpoint);
    }

    /**
     * This method do the DELETE request with an ENDPOINT
     * to API of pivotal tracker
     *
     * @param endpoint
     * @return response from DELETE request
     */
    public static Response deleteRequest(String endpoint) {
        LOGGER.info("DELETE endpoint is: " + endpoint);
        return given().spec(request).when().delete(endpoint);
    }
}

