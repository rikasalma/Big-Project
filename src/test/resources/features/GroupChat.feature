@Group-Chat
Feature: Group Chat
  User can send chat and communication with the team member

  Background: User sign in into cicle
    Given User login with existing account
    When User navigate to dashboard page
    And User select the team

  @PositiviCase @SendMessage
  Scenario Outline: User can send message
    Given User already in Team page
    When User click Group Chat Feature
    And User type Message "<message>"
    And User click send button
    Then User success send message
    Examples:
      | message           |
      | Testing 1         |
      | Test Send Message |
      | Halo Semua        |
      | Selamat Sore      |

  @PositiviCase @DeleteMessage
  Scenario: User can delete message
    Given User already in Team page
    When User click Group Chat Feature
    And User delete message
    Then User success delete message

  @PositiviCase @AttachFile
    Scenario: User can attach file
    Given User already in Team page
    When User click Group Chat Feature
    And User attach the file
    Then User success attach file

  @PositiveCase @DownloadFiles
    Scenario: User can download files
    Given User already in Team page
    When User click Group Chat Feature
    And User click download in the message bubble
    Then User success download file
