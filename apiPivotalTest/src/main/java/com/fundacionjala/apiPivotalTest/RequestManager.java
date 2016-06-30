package com.fundacionjala.apiPivotalTest;

import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public final class RequestManager {
    private static RequestSpecification request = Authentication.getInstance().getRequestSpecification();

    public static Response getRequest(String endpoint){
        return request.get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        System.out.println(parametersJson);
        return request.body(parametersJson).when().post("/"+endpoint);
    }

    public static Response putRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return request.body(parametersJson).when().put("/"+endpoint);
    }

    public static Response deleteRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return request.body(parametersJson).when().delete("/"+endpoint);
    }
}

