Feature: Post Create Transaction
  Post transaction

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
  Scenario Outline: Post create transaction with valid body json and valid token authorization user
    Given Post create transaction with body json "<bodyJson>" and token user
    When Send request post transaction
    Then Status code transaction should be 200
    And Response body name transaction "<message>"
    And Validate transaction json schema "<jsonSchema>"
    Examples:
      | bodyJson                              | message | jsonSchema |
      | CreateTransactionValidJsonSchema.json |         |            |

#    NEGATIVE
  @Project
  Scenario Outline: Post create transaction with invalid body json and valid token authorization user
    Given Post create transaction with invalid body json "<bodyJson>" and valid token user
    When Send request post transaction
    Then Status code transaction should be 400
    And Response body name transaction "<message>"
    Examples:
      | bodyJson                              | message |
      | CreateTransactionInvalidBodyJson.json | dsds    |

    @Project
    Scenario: Post create transaction with valid body json and invalid token authorization user
      Given Post create transaction with valid body json "CreateTransactionValidJsonSchema.json" and invalid token user
      When Send request post transaction
      Then Status code transaction should be 401


