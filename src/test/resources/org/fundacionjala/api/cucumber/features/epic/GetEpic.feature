Feature: Get Epic
  As a user
  I want to get  information of the epics
  Because i need to know the values the epic info

  Background: Create a project
    Given I send a POST request to /projects

      | name   | project for get epics |
      | public | true              |

    And stored as Project1
    And I send a POST request to /projects/[Project1.id]/epics

      | name | Post example hs11h |
    And stored as Epic1

  @smoke_test @epic
  Scenario: Get all epics
    Given I send a GET request to /projects/[Project1.id]/epics endpoint
    Then I expect the status code 200


    @smoke_test @epic
    Scenario: Get epic by id
      Given I send a GET request to /projects/[Project1.id]/epics/[Epic1.id] endpoint
      Then I expect the status code 200


#    @functional_test
#    Scenario: validate epic fields by id
#      Given I have a project created on pivotal tracker
#      And I have the id of that project
#      And I have the ids of the epics
#      And I send a epic GET request to /projects/1600911/epics endpoint
#      And I expect true as result of epics fields validations
