Feature: Post Add a New User
  Create Add a New User

#  POSITIVE
  @Project
  Scenario Outline: Create Add a New User with valid json
    Given Create add a new user with valid json "<bodyJson>"
    When Send request create add a new user
    Then Status Code should be 200
    And Response body name should be "<message>"
    And Validate User json schema "<jsonSchema>"
    Examples:
      | bodyJson                            | message                      | jsonSchema                            |
      | CreateAddANewUserWithValidJson.json | selamat data sudah terdaftar | CreateAddANewWithValidJsonSchema.json |


#   NEGATIVE
  @Project
  Scenario Outline: Create Add a New User with invalid json
    Given Create add a new user with invalid json "<bodyJson>"
    When Send request create add a new user
    Then Status Code should be 400
    Examples:
      | bodyJson                              |
      | CreateAddANewUserWithInvalidJson.json |













