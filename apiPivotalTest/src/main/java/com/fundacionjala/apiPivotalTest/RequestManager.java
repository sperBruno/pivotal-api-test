package com.fundacionjala.apiPivotalTest;

import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class RequestManager {

    private static RequestSpecification REQUEST = Authentication.getInstance().getRequestSpecification();

    private RequestManager() {
    }

    public static Response getRequest(String endpoint) {
             return REQUEST.body("")
                    .when().get(endpoint)
                    .then().contentType(ContentType.JSON)
                    .extract().response();

    }

    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        JSONObject parametersJson = new JSONObject(parameters);
        return REQUEST.body(parametersJson)
                .when().post(endpoint)
                .then().contentType(ContentType.JSON)
                .extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        JSONObject parametersJson = new JSONObject(parameters);
        return REQUEST.body(parametersJson)
                .when().put(endpoint)
                .then().contentType(ContentType.JSON)
                .extract().response();
    }

    public static Response deleteRequest(String endpoint) {
        return REQUEST.body("").when().delete(endpoint);
    }
}

