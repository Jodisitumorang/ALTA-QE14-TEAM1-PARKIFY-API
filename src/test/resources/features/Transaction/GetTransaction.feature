Feature: Get Transaction Id
  Get transaction id

#  POSITIVE
  @Project
  Scenario Outline: Get transaction with valid parameter and valid token authorization operator
    Given Get transaction with valid parameter <id> and valid token authorization
    When Send request get transaction
    Then Status code transaction should be 200
    And Response body name transaction "<message>"
    And Validate transaction json schema "<jsonSchema>"
    Examples:
      | id | message | jsonSchema |
      | 2  |         |            |

#    NEGATIVE
    @Project
    Scenario Outline: Get transaction id with invalid parameter id and valid token authorization operator
      Given Get transaction with invalid parameter "<id>" and token operator
      When Send request get transaction
      Then Status code transaction should be 400
      And Validate transaction json schema "<jsonSchema>"
      Examples:
        | id   | jsonSchema                            |  |  |  |
        | satu | GetTransactionIdInvalidParameter.json |  |  |  |

    @Project
    Scenario Outline: Get transaction id with valid parameter and invali token authorization operator
      Given Get transaction id with valid parameter <id> and invalid token operator
      When Send request get transaction
      Then Status code transaction should be 401
      Examples:
        | id |
        | 23 |



