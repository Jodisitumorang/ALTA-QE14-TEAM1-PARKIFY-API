package starter.stepdef.Parkingslot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parkingslot.ParkingSlotAPI;
import starter.utils.Constants;

import java.io.File;
import java.lang.reflect.Field;

public class PutParkingSlotStepDef {

    @Steps
    ParkingSlotAPI parkingSlotAPI;

//    POSITIVE
    @Given("Put parking slot with valid parameter {} valid body json {string} and valid token operator")
    public void putParkingSlotWithValidParameterValidBodyJsonAndValidTokenOperator(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.putParkingSlotValid(jsonFile, id);
    }

    @When("Send Request put parking slot")
    public void sendRequestPutParkingSlot() {
        SerenityRest.when().put(ParkingSlotAPI.PARKINGS_ID);
    }
    @Then("Status code put parking slot should be {int}")
    public void statusCodePutParkingSlotShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Validate put parking slot json schema {string}")
    public void validatePutParkingSlotJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING_SLOT+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

// NEGATIVE
    @Given("Put parking slot with invalid parameter {string}, valid body json {string} and valid token operator")
    public void putParkingSlotWithInvalidParameterValidBodyJsonAndValidTokenOperator(String id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.putParkingSlotInvalidParameter(jsonFile, id);
    }

    @Given("Put parking slot with valid parameter {}, invalid body json {string} and valid token operator")
    public void putParkingSlotWithValidParameterInvalidBodyJsonAndValidTokenOperator(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.putParkingSlotInvalitBodyJson(jsonFile, id);
    }

    @Given("Put parking slot with valid parameter {}, valid body json {string} and invalid token operator")
    public void putParkingSlotWithValidParameterValidBodyJsonAndInvalidTokenOperator(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.putParkingSlotInvalidToken(jsonFile, id);
    }
}
