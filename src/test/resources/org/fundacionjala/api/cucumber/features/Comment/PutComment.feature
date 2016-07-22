Feature: Update a comment

  Background:
    Given I send a POST request to /projects
      | name   | ProjectTest |
      | public | true        |
    And stored as Project1
    And I send a POST request to /projects/[Project1.id]/stories
      | name | StoryTest |
    And stored as Story1
    Given  I send a POST request to /projects/[Project1.id]/stories/[Story1.id]/comments
      | name | CommentTestToBeChecked |
    And stored as Comment1

  @deleteProject
  Scenario: Update comment
    Given I send a PUT request to /projects/[Project1.id]/stories/[Story1.id]/accounts/[Comment1.id]
      | name | CommentTest Updated |
    Then I expect the status code 200
    And The name field should be equal to CommentTest Updated