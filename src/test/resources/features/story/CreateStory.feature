Feature: Create new story in project from pivotal tracker

  Background: Create Project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1

  @deleteProject
  Scenario: Create new story
    Given I send a POST request to /projects/[Project1.id]/stories
      | name        | newStory    |
      | description | description |
      | estimate    | 1           |
      | story_type  | feature     |
    Then I expect the status code 200
    And I validate fields