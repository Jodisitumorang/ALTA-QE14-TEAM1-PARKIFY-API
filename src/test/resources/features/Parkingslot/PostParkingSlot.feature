Feature: Create Parking Slot
  Post parking slot

  #  Background:
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
  Scenario Outline: Post create parking slot with valid body json and token authorization operator
    Given Post create parking slot with valid body json "<bodyJson>" and valid token operator
    When Send request post create parking slot
    Then Status code post parking slot should be 201
    And Response body name parking slot "<message>"
    And Validate post parking slot json schema "<jsonSchema>"
    Examples:
      | bodyJson                            | message                  | jsonSchema                            |
      | CreateParkingSlotValidBodyJson.json | success add parking slot | CreateParkingSlotValidJsonSchema.json |

#    NEGATIVE
  @Project
  Scenario Outline: Post create parking slot with invalid body json and valid token authorization operator
    Given Post create parking slot with invalid bodi json "<bodyJson>" and valid token operator
    When Send request post create parking slot
    Then Status code post parking slot should be 400
    And Response body name parking slot "<message>"
    Examples:
      | bodyJson                              | message                           |
      | CreateParkingSLotInvalidBodyJson.json | data yang dikirimkan tidak sesuai |

    @Project
    Scenario: Post create parking slot with valid body json and invalid token authorization operator
      Given Post create parking slot with valid body json "PostParkingSlotInvalidToken.json" and invalid token authorization operator
      When Send request post create parking slot
      Then Status code post parking slot should be 401