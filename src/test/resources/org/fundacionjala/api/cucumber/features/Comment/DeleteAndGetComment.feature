Feature: Get Comment

  Background: Connection
    Given I send a POST request to /projects
      | name   | ProjectTest |
      | public | true        |
    And stored as Project1
    And I send a POST request to /projects/[Project1.id]/stories
      | name | StoryTest |
    And stored as Story1
    And  I send a POST request to /projects/[Project1.id]/stories/[Story1.id]/comments
      | name | CommentTestToBeChecked |
    And stored as Comment1

  @deleteProject
  Scenario: Accounts endpoint availability
    Given I send a GET request to /projects/[Project1.id]/stories/[Story1.id]/accounts/[Comment1.id] endpoint
    Then I expect the status code 200
    And I expect that [Comment1.name] be CommentTest


  @deleteProject
  Scenario: Deleting a comment
    Given I have the /projects/[Project1.id]/stories/[Story1.id]/comments/[Comment1.id] endpoint
    And I send a DELETE request
    Then I expect the status code 204