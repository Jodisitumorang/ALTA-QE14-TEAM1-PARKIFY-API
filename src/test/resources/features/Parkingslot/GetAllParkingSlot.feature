Feature: Get All Parking Slot
  Get all parking slot


  #  Background
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
  Scenario Outline: Get all parking slot with valid token authorization operator
    Given Get all parking slot with valid token operator
    When Send request get all parking slot
    Then Status code get all parking slot should be 200
    And Response body name parking slot "<message>"
    And Validate get all parking slot json schema "<jsonSchema>"
    Examples:
      | message                      | jsonSchema                  |
      | success get all parking slot | GetAllParkingSlotValid.json |

#    NEGATIVE
  @Project
  Scenario: Get all parking slot with invalid token authorization operator
    Given Get all parking slot with invalid token operator
    When Send request get all parking slot
    Then Status code get all parking slot should be 401