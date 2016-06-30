package com.fundacionjala.apiPivotalTest;

import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class Request {
    private RequestSpecification response;
    public Request(){
        response = Authentication.getInstance().getRequestSpecification();
    }

    public Response getRequest(String endpoint){
        return response.when().get(endpoint);
    }

    public Response postRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        System.out.println(parametersJson);
        return response.contentType("application/json").and().body(parametersJson).when().post("/"+endpoint);
    }

    public Response putRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return response.contentType("application/json").and().body(parametersJson).when().put("/"+endpoint);
    }

    public Response deleteRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return response.contentType("application/json").and().body(parametersJson).when().delete("/"+endpoint);
    }
}

