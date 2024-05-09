package starter.stepdef.Parkingslot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parkingslot.ParkingSlotAPI;
import starter.jsonph.Parkingslot.ParkingSlotResponse;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostParkingSlotStepDef {

    @Steps
    ParkingSlotAPI parkingSlotAPI;
    @Given("Post create parking slot with valid body json {string} and valid token operator")
    public void postCreateParkingSlotWithValidBodyJsonAndValidTokenOperator(String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.postCreateParkingSlotValid(jsonFile);
    }

    @When("Send request post create parking slot")
    public void sendRequestPostCreateParkingSlot() {
        SerenityRest.when().post(ParkingSlotAPI.PARKING_SLOT);
    }

    @Then("Status code post parking slot should be {int}")
    public void statusCodePostParkingSlotShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Response body name parking slot {string}")
    public void responseBodyNameParkingSlot(String message) {
        SerenityRest.and().body(ParkingSlotResponse.MESSAGE,equalTo(message));
    }

    @And("Validate post parking slot json schema {string}")
    public void validatePostParkingSlotJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING_SLOT+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Post create parking slot with invalid bodi json {string} and valid token operator")
    public void postCreateParkingSlotWithInvalidBodiJsonAndValidTokenOperator(String json) {
        File jsonFile = new File(Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.postCreatParkingSlotInvalidBodyJson(jsonFile);
    }

    @Given("Post create parking slot with valid body json {string} and invalid token authorization operator")
    public void postCreateParkingSlotWithValidBodyJsonAndInvalidTokenAuthorizationOperator(String json) {
        File jsonFile = new File( Constants.REQ_BODY_PARKING_SLOT+json);
        parkingSlotAPI.postCreateParkingSlotInvalidToken(jsonFile);
    }
}
