Feature: Create Add a New Parking
  Post create add a new parking

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
  Scenario Outline: Post create add a new parking with valid body json and token authorization operator
    Given Post create add a new parking with valid location "Lapangan Merdeka", city "Kota Tebing Tinggi", imageloc "lpp.jpg"
    When Send request post create add a new parking
    Then Status code parking should be 200
    And Response body name parking should be "Adding Parking Success"
    And Validate add a new parking json schema "<jsonSchema>"
    Examples:
      | jsonSchema                               |
      | CreateAddANewParkingValidJsonSchema.json |

#    NEGATIVE
  @Project
  Scenario: Post create add a new parking with invalid body json and valid token authorization operator
    Given Post create add a new parking with invalid location "", city "Kota Tebing Tinggi", imageloc "lpp.jpg"
    When Send request post create add a new parking
    Then Status code parking should be 500
    And Response body name parking should be "terjadi kesalahan pada proses server"
    And Validate add a new parking json schema "CreateAddANewParkingWithInvalidJsonSchema.json"

   @Project
   Scenario: Post create add a new parking with valid json and invalid token authorization operator
     Given Post create add a new parking with valid location "Lapangan Merdeka", city "Kota Tebing Tinggi", imageLoc "lpp.jpg"
     When Send request post create add a new parking
     Then Status code parking should be 401
