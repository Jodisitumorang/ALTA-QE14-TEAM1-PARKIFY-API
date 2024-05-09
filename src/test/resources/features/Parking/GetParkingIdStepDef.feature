Feature: Get Parking Id
  Get parking id with parameter and token authorization operator

#  POSITIVE
  @Project
  Scenario Outline: Get parking id with valid parameter id and valid token authorization operator
    Given Get parking id with valid parameter <id> and valid token operator
    When Send request get parking id
    Then Status code parking should be 200
    And Response body name parking should be "<message>"
    And Validate get parking json schema "<jsonSchema>"
    Examples:
      | id | message                   | jsonSchema                       |
      | 47 | berhasil mendapatkan data | GetParkingIdValidJsonSchema.json |

#    NEGATIVE
  @Project
  Scenario Outline: Get parking id with invalid parameter and valid token authorization operator
    Given Get parking id with invalid parameter <id> and valid token operator
    When Send request get parking id
    Then Status code parking should be 400
    And Response body name parking should be "<message>"
    And Validate get parking json schema "<jsonSchema>"
    Examples:
      | id         | message                           | jsonSchema                                |
      | empattujuh | data yang dikirimkan tidak sesuai | GetParkingIdValidParameterJsonSchema.json |

  @Project
  Scenario: Get parking id with valid parameter and invalid token authorization operator
    Given Get parking id with valid parameter 47 and invalid token operator
    When Send request get parking id
    Then Status code parking should be 401
