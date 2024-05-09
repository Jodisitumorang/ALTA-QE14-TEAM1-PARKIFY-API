Feature: Get Reservation Id
  Get reservation id

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
  Scenario Outline: Get reservation with valid parameter id and valid token authorization operator
    Given Get reservation with valid parameter <id> and valid token operator
    When Send request get reservation id
    Then Status code get reservation should be 200
    And Response body name get reservation "<message>"
    And Validate get Reservation json schema "<jsonSchema>"
    Examples:
      | id | message                      | jsonSchema                          |
      | 35 | success get reservation info | GetReservationIdValidParameter.json |

#    NEGATIVE
  @Project
  Scenario Outline: Get reservation with invalid parameter id and valid token authorization operator
    Given Get reservation with invalid paramter "<id>" and valid token operator
    When Send request get reservation id
    Then Status code get reservation should be 400
    Examples:
      | id       |
      | tigalima |

    @Project
    Scenario Outline: Get reservation with valid parameter id and invalid token authorization operator
      Given Get reservation with valid parameter <id> and invalid token operator
      When Send request get reservation id
      Then Status code get reservation should be 401
      Examples:
        | id |
        | 35 |
