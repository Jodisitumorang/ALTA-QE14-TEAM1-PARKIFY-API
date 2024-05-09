package starter.stepdef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.jsonph.Login.LoginAPI;
import starter.utils.Constants;

import java.io.File;

public class ResponseStepDef {


    //    Send Request
    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(LoginAPI.LOGIN);
    }

//    Status Code
    @Then("Status code Login should be {int}")
    public void statusCodeLoginShouldBe(int statusCode) {
    SerenityRest.and().statusCode(statusCode);
}

//    Validate Json Schema
    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_LOGIN+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}
