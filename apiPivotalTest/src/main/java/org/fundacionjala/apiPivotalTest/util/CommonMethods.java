package org.fundacionjala.apiPivotalTest.util;

import java.util.ArrayList;
import java.util.Map;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.apiPivotalTest.api.RequestManager.deleteRequest;
import static org.fundacionjala.apiPivotalTest.api.RequestManager.getRequest;
import static org.fundacionjala.apiPivotalTest.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.apiPivotalTest.util.Constants.PROJECT_ID;

/**
 * Created by mijhailvillarroel on 7/14/2016.
 */
public final class CommonMethods {

    private CommonMethods() {
    }

    public static void deleteAllProjects() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(getRequest(PROJECTS_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(PROJECTS_ENDPOINT + object.get(PROJECT_ID).toString());
            }
        }
    }
}
