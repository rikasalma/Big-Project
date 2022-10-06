@Blast-Feature
Feature: Blast

  Background: User sign in into cicle
    Given User login with existing account
    When User navigate to dashboard page
    And User select the team

  @PositiveCase @CreatePublicBlast
    Scenario: User can create public blast
    Given User already in Team page
    When User click blast feature
    And User click create blast
    And User type title "Blast 2"
    And User write the description "Halo Semua"
    And User click publish button
    Then User success create blast

  @PositiveCase @CreatePrivateBlast
  Scenario: User can create private blast
    Given User already in Team page
    When User click blast feature
    And User click create blast
    And User type title "Blast 1"
    And User write the description "Halo Semua"
    And User switch toggle to private
    And User click publish button
    Then User success create blast

  @NegativeCase @CreatedBlast
  Scenario: User can't create blast
    Given User already in Team page
    When User click blast feature
    And User click create blast
    And User click publish button
    Then User failed create blast

  @PositiveCase @AddCommentBlast
    Scenario: User add comment on blast
    Given User already in Team page
    When User click blast feature
    And User click one of the blast
    And User type comment "Comment 1"
    And User click post button
    Then User success add comment
