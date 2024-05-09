Feature: Create Login User
  Post create login

#  POSITIVE
  @Project
  Scenario Outline: Post create login user with valid body json
    Given Create login user with valid body json "<bodyJson>"
    When Send request post login user
    Then Status code Login should be 200
    And Response body name should be "<message>"
    And Validate login user json schema "<jsonSchema>"
    Examples:
      | bodyJson                                  | message        | jsonSchema                          |
      | CreateLoginUserValidEmailAndPassword.json | berhasil login | CreateLoginUserValidJsonSchema.json |

#    NEGATIVE
  @Project
  Scenario: Post create login user with invalid email body json
    Given Post create login user with invalid email body json "CreateLoginUserWithInvalidBodyJson.json"
    When Send request post login user
    Then Status code Login should be 400
    And Response body name should be "mohon cek kembali email atau password yang diinputkan"

  @Project
  Scenario: Post create login user with invalid password body json
    Given Post create login user with invalid password body json "CreateLoginUserInvalidPasswordBodyJson.json"
    When Send request post login user
    Then Status code Login should be 400
    And Response body name should be "mohon cek kembali email atau password yang diinputkan"