Feature: Delete Parking Slot Id
  Delete parking slot id

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
  Scenario Outline: Delete parking slot with valid parameter id and token authorization operator
    Given Delete parking slot with valid parameter <id> and valid token operator
    When Send request delete parking slot
    Then Status code delete parking slot 200
    And Response body name parking slot "<message>"
    And Validate delete parking slot json schema "<jsonSchema>"
    Examples:
      | id | message                     | jsonSchema                  |  |  |
      | 36  | success delete parking slot | DeleteParkingSlotValid.json |  |  |

#    NEGATIVE
  @Project
  Scenario Outline: Delete parking slot with invalid parameter and valid token authorization operator
    Given Delete parking slot with invalid parameter <id> and valid token operator
    When Send request delete parking slot
    Then Status code delete parking slot 400
    Examples:
      | id       |
      | empatdua |

  @Project
  Scenario Outline: Delete parking slot with valid parameter and invalid token authorization operator
    Given Delete parking slot with valid parameter <id> and invalid token operator
    When Send request delete parking slot
    Then Status code delete parking slot 401
    Examples:
      | id |
      | 42 |
