Feature: Post Create Reservation
  Post create reservation

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
  Scenario Outline: Post create reservation with valid body json and valid token authorization operator
    Given Post create reservation with valid body json "<bodyJson>" and valid token operator
    When Send request post reservation
    Then Status code post reservation should be 201
    And Response body name reservation "<message>"
    And Validate post reservation json schema "<jsonSchema>"
    Examples:
      | bodyJson                  | message                    | jsonSchema                          |
      | PostReservationValid.json | success create reservation | PostReservationValidJsonSchema.json |

#    NEGATIVE
  @Project
  Scenario Outline: Post create reservation with invalid body json and valid token authorization operator
    Given Post create reservation with invalid body json "<bodyJson>" and valid token operator
    When Send request post reservation
    Then Status code post reservation should be 400
    Examples:
      | bodyJson                            |
      | PostReservationInvalidBodyJson.json |

  @Project
  Scenario: post create reservation with valid body json and invalid token authorization operator
    Given Post create reservation with valid body json "PostReservationInvalidToken.json" and invalid token operator
    When Send request post reservation
    Then Status code post reservation should be 401

