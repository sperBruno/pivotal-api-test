Feature: Update a story in project from pivotal tracker

  Background: Create Project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1

    Given I send a POST request to /projects/[Project1.id]/stories
      | name     | story |
      | estimate | 1     |
    And stored as Storie1


  @deleteProjectStory
  Scenario: Edit a story
    Given I send a PUT request to /projects/[Storie1.project_id]/stories/[Storie1.id]
      | name | newStory |
    Then I expect the status code 200
    And I validate fields


  Scenario: Delete a story
    Given I have the /projects/[Storie1.project_id]/stories/[Storie1.id] endpoint
    When I send a DELETE request
    Then I expect the status code 204