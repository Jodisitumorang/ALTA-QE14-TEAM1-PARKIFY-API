Feature: Update user
  Update user

#  POSITIVE
  @Project
  Scenario Outline: Update user with valid body json and valid token authorization user
    Given Put user with valid body json "<bodyJson>" and valid token authorization user
    When Send request put user
    Then Status Code should be 201
    And Response body name should be "<message>"
    And Validate User json schema "<jsonSchema>"
    Examples:
      | bodyJson                         | message                  | jsonSchema                         |
      | UpdateUserWithValidBodyJson.json | berhasil merubah profile | UpdateUserWithValidJsonSchema.json |

#    NEGATIVE
  @Project
  Scenario Outline: Update user with invalid body json and valid token user
    Given Put user with invalid body json "<bodyJson>" and valid token user
    When Send request put user
    Then Status Code should be 400
    Examples:
      | bodyJson                       |  |
      | UpdateUserWithInvalidJson.json |  |

  @Project
  Scenario Outline: Update user with valid body json and invalid token user
    Given Put user with valid body json "<bodyJson>" and invalid token user
    When Send request put user
    Then Status Code should be 401
    Examples:
      | bodyJson                          |  |
      | UpdateUserWithValidBodyJson2.json |  |