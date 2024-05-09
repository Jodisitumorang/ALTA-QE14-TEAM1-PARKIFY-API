Feature: Delete User
  Delete User

#  POSITIVE
  @Project
  Scenario: Delete user with valid token authorization user
    Given Delete user with valid token user
    When Send request delete user
    Then Status Code should be 200

#    NEGATIVE
  @Project
  Scenario: Delete user with invalid token authorization user
    Given Delete user with invalid token user
    When Send request delete user
    Then Status Code should be 401