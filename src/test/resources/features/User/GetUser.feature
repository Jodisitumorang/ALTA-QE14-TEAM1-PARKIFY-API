Feature: Get User
  Get user

#  POSITIVE
  @Project
  Scenario Outline: Get user with valid token authorization user
    Given Get user with valid token authorization user
    When Send request get user
    Then Status Code should be 200
    And Response body should be <userId> and "<fullName>"
    And Validate User json schema "<jsonSchema>"
    Examples:
      | userId | fullName    | jsonSchema                           |  |
      | 167    | Jodi User 2 | GetUserWithValidTokenJsonSchema.json |  |


#    NEGATIVE
      @Project
      Scenario: Get user with invalid token authorization user
        Given Get user with invalid token authorization user
        When Send request get user
        Then Status Code should be 401

