Feature:Delete project

  Background: Create a project
    Given I have the next parameters:

      | name   | project to delete |
      | public | true              |

    And I have the /projects endpoint
    And I sent a POST request
    And stored as Project1

  Scenario: Delete project
    Given I have the /projects/[Project1.id] endpoint
    When I send a DELETE request
    Then I expect the status code 204
