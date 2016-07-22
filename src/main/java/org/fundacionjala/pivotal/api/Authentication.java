package org.fundacionjala.pivotal.api;

import com.github.markusbernhardt.proxy.ProxySearch;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fundacionjala.pivotal.util.PropertiesInfo;

import static com.jayway.restassured.RestAssured.baseURI;

/**
 * @author Henrry Salinas.
 */
public class Authentication {
    private static final String SRC_MAIN_RESOURCES_LOG4J_PROPERTIES = "src/main/resources/log4j.properties";

    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getSimpleName());

    private static final String TOKEN_HEADER = "X-TrackerToken";

    private static final String HTTP_PROXY_HOST = "http.proxyHost";

    private static final String HTTP_PROXY_PORT = "http.proxyPort";

    private static Authentication instance;

    private RequestSpecification requestSpecification;

    private Authentication() {
        initApi();
        PropertyConfigurator.configure(SRC_MAIN_RESOURCES_LOG4J_PROPERTIES);
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        baseURI = PropertiesInfo.getInstance().getUrlApi();
        if (ProxySearch.getDefaultProxySearch().getProxySelector() == null) {
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                    .build();
        } else {
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .setProxy(PropertiesInfo.getInstance().getProxy())
                    .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                    .build();
        }
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
