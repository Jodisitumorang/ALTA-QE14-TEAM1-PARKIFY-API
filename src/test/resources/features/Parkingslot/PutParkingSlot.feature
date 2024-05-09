Feature: Put Parking Slot
  Put parking slot

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
  Scenario Outline: Put parking slot with valid parameter, valid body json and valid token authorization operator
    Given Put parking slot with valid parameter <id> valid body json "<bodyJson>" and valid token operator
    When Send Request put parking slot
    Then Status code put parking slot should be 200
    And Response body name parking slot "<message>"
    And Validate put parking slot json schema "<jsonSchema>"
    Examples:
      | id | bodyJson                     | message                   | jsonSchema                   |
      | 31 | PutParkingSlotValidData.json | success edit parking slot | PutParkingSlotValidData.json |

#    NEGATIVE
  @Project
  Scenario Outline: Put parking slot with invalid parameter, valid body json and valid token authorization operator
    Given Put parking slot with invalid parameter "<id>", valid body json "<bodyJson>" and valid token operator
    When Send Request put parking slot
    Then Status code put parking slot should be 400
    Examples:
      | id       | bodyJson                            |  |
      | tigasatu | PutParkingSlotInvalidParameter.json |  |

  @Project
  Scenario Outline: Put parking slot with valid parameter, invalid body json and valid token authorization operator
    Given Put parking slot with valid parameter <id>, invalid body json "<bodyJson>" and valid token operator
    When Send Request put parking slot
    Then Status code put parking slot should be 400
    And Response body name parking slot "<message>"
    Examples:
      | id | bodyJson                           | message                           |
      | 31 | PutParkingSlotInvalidBodyJson.json | data yang dikirimkan tidak sesuai |

  @Project
  Scenario Outline: Put parking slot with valid parameter, valid body json and invalid token authorization operator
    Given Put parking slot with valid parameter <id>, valid body json "<bodyJson>" and invalid token operator
    When Send Request put parking slot
    Then Status code put parking slot should be 401
    Examples:
      | id | bodyJson                        |  |
      | 31 | PutParkingSlotInvalidToken.json |  |
