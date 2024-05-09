Feature: Update All Parking
  Put all parking


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
  Scenario: Put parking with valid parameter id, valid json and valid token authorization operator
    Given Put parking with valid parameter id 47, valid json location "Danau Toba Leek", city "Parapat", imageloc "dt.jpg" and valid authorization operator
    When Send request put parking
    Then Status code parking should be 200
    And Response body name parking should be "Update Profile Success"
    And Validate put parking json schema "PutParkingIdValidData.json"


#    NEGATIVE
  @Project
  Scenario Outline: Put parking with invalid parameter id, valid json and valid token authorization operator
    Given Put parking with invalid parameter id "<id>", valid json location "Danau Toba Leek", city "Parapat", imageloc "dt.jpg" and valid authorization operator
    When Send request put parking
    Then Status code parking should be 400
    And Response body name parking should be "<message>"
    And Validate put parking json schema "<jsonSchema>"
    Examples:
      | id         | message                           | jsonSchema                        |
      | empatTujuh | data yang dikirimkan tidak sesuai | PutParkingIdInvalidParameter.json |

  @Project
  Scenario: Put parking with invalid parameter id, valid json and invalid token authorization operator
    Given Put parking with valid parameter 47, valid location "Danau Toba mantap", city "Parapat", imageLoc "dt.jpg"
    When Send request put parking
    Then Status code parking should be 401
