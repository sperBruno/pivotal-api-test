@story
Feature: Update Story

  Background: create a story inside a new project
    Given I have the next parameters:

      | name   | project to create stories |
      | public | true                      |

    And I have the /projects endpoint
    And I sent a POST request
    And stored as Project1
    And I have the /projects/[Project1.id]/stories endpoint
    And I have the next parameters:

      | name        | story example          |
      | description | example of description |

    And I send a POST request
    And stored as Story1

  @story
  Scenario: Update a story
    Given I have the /projects/[Project1.id]/stories/[Story1.id] endpoint
    And I have the next parameters:

      | name        | story example  updated         |
      | description | example of description updated |

    When I send a PUT request
    Then I expect the status code 200
    And The story name should be equal to story example  updated