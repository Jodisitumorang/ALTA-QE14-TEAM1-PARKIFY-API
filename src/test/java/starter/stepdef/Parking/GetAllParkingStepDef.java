package starter.stepdef.Parking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parking.ParkingAPI;
import starter.jsonph.Parking.ParkingResponse;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;


public class GetAllParkingStepDef {

    @Steps
    ParkingAPI parkingAPI;

    @Given("Get all parking with valid token authorization operator")
    public void getAllParkingWithValidTokenAuthorizationOperator() {
        parkingAPI.getAllParkingValidToken();
    }
    @When("Send request get all parking")
    public void sendRequestGetAllParking() {
        SerenityRest.when().get(ParkingAPI.PARKING);
    }
    @And("Response body name all parking should be {string}")
    public void responseBodyNameAllParkingShouldBe(String message) {
        SerenityRest.and().body(ParkingResponse.MESSAGE,equalTo(message));
    }
    @And("Validate get all parking json schema {string}")
    public void validateGetAllParkingJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @Given("Get all parking with invalid token authorization operator")
    public void getAllParkingWithInvalidTokenAuthorizationOperator() {
        parkingAPI.getAllParkingInvalidToken();
    }
}
