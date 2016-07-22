package org.fundacionjala.api.cucumber.steps;

        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;

        import static org.fundacionjala.api.util.CommonMethods.getStringValueFromMapOfResponses;
        import static org.junit.Assert.assertEquals;

public class Asserts {

    public static final int INDEX_1 = 0;
    public static final int INDEX_2 = 1;
    private ApiResources api;

    public Asserts(ApiResources api) {
        this.api = api;
    }

    @And("^The (.*?) field should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String fieldName, String expectedValue) {
        assertEquals(expectedValue, api.getResponse().path(fieldName));
    }

    @Then("^I expect that \\[(.*)\\] be (.*)$")
    public void iExpectThatCommentNameBe(String expectedName, String expectedResult) {
        String[] value = expectedName.split(".");
        String actualResult = getStringValueFromMapOfResponses(value[INDEX_1], value[INDEX_2]);
        assertEquals(expectedName, actualResult);
    }
}
