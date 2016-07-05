Feature:Update project

  Background: set connection to pivotal tracker API REST
    Given I have the next parameters:

      | name   | project to update |
      | public | true              |

    And I have the /projects endpoint
    And I sent a POST request
    And stored as Project1

  @project
  Scenario: Update name of project
    Given I have the next parameters:

      | name   | project updated |

    And I have the /projects/[Project1.id] endpoint
    When I send a PUT request
    Then I expect the status code 200
    And The project name should be equal to project updated
