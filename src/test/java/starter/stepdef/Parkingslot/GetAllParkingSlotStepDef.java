package starter.stepdef.Parkingslot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parking.ParkingAPI;
import starter.jsonph.Parkingslot.ParkingSlotAPI;
import starter.utils.Constants;

import java.io.File;

public class GetAllParkingSlotStepDef {

    @Steps
    ParkingSlotAPI parkingSlotAPI;

//    POSITIVE
    @Given("Get all parking slot with valid token operator")
    public void getAllParkingSlotWithValidTokenOperator() {
        parkingSlotAPI.getAllParkingSlotValid();
    }

    @When("Send request get all parking slot")
    public void sendRequestGetAllParkingSlot() {
        SerenityRest.when().get(ParkingSlotAPI.PARKING_SLOT);
    }

    @Then("Status code get all parking slot should be {int}")
    public void statusCodeGetAllParkingSlotShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Validate get all parking slot json schema {string}")
    public void validateGetAllParkingSlotJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING_SLOT+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get all parking slot with invalid token operator")
    public void getAllParkingSlotWithInvalidTokenOperator() {
        parkingSlotAPI.getAllParkingSlotInvalidToken();
    }
}
