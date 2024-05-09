Feature: Get All Parking
  Get all parking


  @Project
  Scenario Outline: : Already login operator
    Given User operator login with email "<json>"
    When Send request post login operator
    Then Status code parking should be 200
    Examples:
      | json                   |
      | PostLoginOperator.json |

#  POSITIVE
  @Project
  Scenario Outline: Get all parking with valid token authorization operator
    Given Get all parking with valid token authorization operator
    When Send request get all parking
    Then Status code parking should be 200
    And Response body name all parking should be "<message>"
    And Validate get all parking json schema "<jsonSchema>"
    Examples:
      | message                  | jsonSchema                                 |
      | successfully get parking | GetAllParkingWithValidTokenJsonSchema.json |

#   NEGATIVE
  @Project
  Scenario: Get all parking with invalid token authorization operator
    Given Get all parking with invalid token authorization operator
    When Send request get all parking
    Then Status code parking should be 401
