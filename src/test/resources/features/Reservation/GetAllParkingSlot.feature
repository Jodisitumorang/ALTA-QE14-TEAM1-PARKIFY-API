Feature: Get All Reservation
  Get all reservation

    #  Background
  @Project
  Scenario Outline: : Already login operator
    Given User operator login with email "<json>"
    When Send request post login operator
    Then Status code parking should be 200
    Examples:
      | json                   |
      | PostLoginOperator.json |

#    POSITIVE
  @Project
  Scenario Outline: Get all reservation with valid token authorization operator
    Given Get all reservation with valid token operator
    When Send request get all reservation
    Then Status code get all reservation should be 200
    And Response body name all reservation "<message>"
    And Validate get reservation json schema "<jsonSchema>"
    Examples:
      | message                         | jsonSchema                       |
      | success get reservation history | GetAllReservationValidToken.json |

#    NEGATIVE
  @Project
  Scenario: Get all reservation with invalid token authorization operator
    Given Get all reservation with invalid token operator
    When Send request get all reservation
    Then Status code get all reservation should be 401

