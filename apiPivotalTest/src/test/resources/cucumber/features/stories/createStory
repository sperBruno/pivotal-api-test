Feature: Create Story

  Background: create project
    Given I have the next parameters:

      | name   | project to create stories |
      | public | true                      |

    And I have the /projects endpoint
    And I sent a POST request
    And stored as Project1

  @story
  Scenario: Create a story
    Given I have the /projects/[Project1.id]/stories endpoint
    And I have the next parameters:

      | name        | story example          |
      | description | example of description |

    When I send a POST request
    Then I expect the status code 200
    And The story name should be equal to story example
