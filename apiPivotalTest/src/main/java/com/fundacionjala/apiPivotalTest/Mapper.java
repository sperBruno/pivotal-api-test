package com.fundacionjala.apiPivotalTest;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.path.json.JsonPath.from;

public class Mapper {

    public static String getField(Response response, String parameter) {
        return from(response.asString()).get(parameter).toString();
    }
}
