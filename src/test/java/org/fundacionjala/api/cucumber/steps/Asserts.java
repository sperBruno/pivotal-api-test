package org.fundacionjala.api.cucumber.steps;

        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import org.apache.log4j.Logger;

        import static org.fundacionjala.api.util.CommonMethods.getStringValueFromMapOfResponses;
        import static org.junit.Assert.assertEquals;

public class Asserts {

    private static final int INDEX_1 = 0;

    private static final int INDEX_2 = 1;

    private ApiResources api;

    private static final Logger LOGGER  =Logger.getLogger(Asserts.class.getName());

    public Asserts(ApiResources api) {
        this.api = api;
    }

    @And("^The (.*?) field should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String fieldName, String expectedValue) {
        assertEquals(expectedValue, api.getResponse().path(fieldName));
    }

    @Then("^I expect that \\[(.*)\\] be (.*)$")
    public void iExpectThatCommentNameBe(String expectedName, String expectedResult) {
        LOGGER.info("values size: "+ expectedName);
        String[] value = expectedName.split("\\.");
        LOGGER.info("values size: "+ value.length);
        LOGGER.info("values: "+ value[0] +" "+ value[1]);
        String actualResult = getStringValueFromMapOfResponses(value[INDEX_1], value[INDEX_2]);
        assertEquals(expectedResult, actualResult);
    }
}
