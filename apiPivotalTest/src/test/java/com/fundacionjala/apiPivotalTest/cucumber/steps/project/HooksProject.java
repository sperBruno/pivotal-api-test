package com.fundacionjala.apiPivotalTest.cucumber.steps.project;

import java.util.ArrayList;
import java.util.Map;

import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.fundacionjala.apiPivotalTest.RequestManager.deleteRequest;
import static com.fundacionjala.apiPivotalTest.RequestManager.getRequest;
import static com.jayway.restassured.path.json.JsonPath.from;

public class HooksProject {
    private Response response;
    private static boolean dunit = false;

    @After("@project")
    public void afterScenario() {
        response = getRequest("/projects");
        if(response.statusCode()==200){
            deleteProjects();
        }
    }
    public void deleteProjects(){
        ArrayList<Map<String, ?>> jsonAsArrayList = from(response.asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest("/projects/" + object.get("id"));
            }
        }
    }
}
