package com.fundacionjala.apiPivotalTest;

import com.jayway.restassured.specification.RequestSpecification;

import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

public class Authentication {

    private final static Logger LOGGER = Logger.getLogger(RequestManager.class);

    public static final String CONTENT_TYPE = "application/json";

    public static final String TOKEN_HEADER = "X-TrackerToken";

    private static Authentication instance;

    private RequestSpecification requestSpecification;

    private Authentication() {
        initApi();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        try {
            baseURI = PropertiesInfo.getInstance().getBaseUrl();
            requestSpecification = given().relaxedHTTPSValidation()
                    .proxy(PropertiesInfo.getInstance().getProxy())
                    .header(TOKEN_HEADER, PropertiesInfo.getInstance().getToken())
                    .contentType(CONTENT_TYPE);
            LOGGER.info("The api was initialized");
        } catch (Exception e) {
            LOGGER.fatal("Fatal error initializing the api properties "+e.getMessage());
        }
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
