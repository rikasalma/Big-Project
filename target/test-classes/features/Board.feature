@Board-Feature
Feature: Board
  User can manage and add list

  Background: User sign in into cicle
    Given User login with existing account
    When User navigate to dashboard page
    And User select the team

  @PositiveCase @CreateNewList
  Scenario Outline: User can create new list on board
    Given User already in Team page
    When User click Board Feature
    And User click Add List
    And User type list name "<list name>"
    And User click create button
    Then User success create new list
    Examples:
      | list name   |
      | To Do       |
      | In Progress |
      | Done        |

  @NegativeCase @CreateNewList
  Scenario: User can't create new list on board
    Given User already in Team page
    When User click Board Feature
    And User click Add List
    And User didn't type list name
    And User click create button
    Then User failed create new list

  @PositiveCase @CancelCreateNewList
  Scenario: User cancel create new list
    Given User already in Team page
    When User click Board Feature
    And User click Add List
    And User type list name "List 1"
    And User click cancel button
    Then User success cancel create new list

  @PositiveCase @AddPublicCard
    Scenario: User can create public card on list board
    Given User already in Team page
    When User click Board Feature
    And User click add card in one of the list
    And User type card name
    And User click add card button
    Then User success add card

  @PositiveCase @AddPrivateCard
  Scenario: User can create private card on list board
    Given User already in Team page
    When User click Board Feature
    And User click add card in one of the list
    And User type card name
    And User switch toggle to private
    And User click add card button
    Then User success add card

  @NegativeCase @AddCard
  Scenario: User can't add card on list board
    Given User already in Team page
    When User click Board Feature
    And User click add card in one of the list
    And User didn't type card name
    And User click add card button
    Then User failed add card
