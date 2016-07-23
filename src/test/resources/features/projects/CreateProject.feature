Feature: Testing for login Pivotal page

  @DeleteProject
  Scenario: Create project
    Given I send a POST request to /projects
      | name   | TestCreateProjects238 |
      | public | true                  |
    Then I expect the status code 200