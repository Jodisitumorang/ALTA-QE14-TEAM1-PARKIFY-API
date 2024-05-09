package starter.stepdef.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.jsonph.User.UserAPI;
import starter.utils.Constants;

import java.io.File;

public class ResponseStepDef {



    @Then("Status Code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Validate User json schema {string}")
    public void validateUserJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_USER+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }









}

