package starter.stepdef.Parking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parking.ParkingAPI;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetParkingIdStepDef {

    @Steps
    ParkingAPI parkingAPI;

//  POSITIVE
    @Given("Get parking id with valid parameter {} and valid token operator")
    public void getParkingIdWithValidParameterAndValidTokenOperator(int id) {
        parkingAPI.getParkingIdValidData(id);
    }

    @When("Send request get parking id")
    public void sendRequestGetParkingId() {
        SerenityRest.when().get(ParkingAPI.PARKING_ID);
    }

    @And("Validate get parking json schema {string}")
    public void validateGetParkingJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

//  NEGATIVE
    @Given("Get parking id with invalid parameter {} and valid token operator")
    public void getParkingIdWithInvalidParameterAndValidTokenOperator(String id) {
        parkingAPI.getParkingIdInvalidParameter(id);
    }

    @Given("Get parking id with valid parameter {} and invalid token operator")
    public void getParkingIdWithValidParameterAndInvalidTokenOperator(int id) {
        parkingAPI.getParkingIdInvalidToken(id);
    }
}
