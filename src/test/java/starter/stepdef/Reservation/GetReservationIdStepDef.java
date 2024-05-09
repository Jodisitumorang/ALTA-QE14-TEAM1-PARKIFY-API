package starter.stepdef.Reservation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Reservation.ReservationAPI;
import starter.jsonph.Reservation.ResponseReservation;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetReservationIdStepDef {

    @Steps
    ReservationAPI reservationAPI;

    @Given("Get reservation with valid parameter {} and valid token operator")
    public void getReservationWithValidParameterAndValidTokenOperator(int id) {
        reservationAPI.getReservationIdValidParameter(id);
    }

    @When("Send request get reservation id")
    public void sendRequestGetReservationId() {
        SerenityRest.when().get(ReservationAPI.RESERVATION_ID);
    }
    @Then("Status code get reservation should be {int}")
    public void statusCodeGetReservationShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Response body name get reservation {string}")
    public void responseBodyNameGetReservation(String message) {
        SerenityRest.and().body(ResponseReservation.MESSAGE,equalTo(message));
    }

    @And("Validate get Reservation json schema {string}")
    public void validateGetReservationJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_RESERVATION+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @Given("Get reservation with invalid paramter {string} and valid token operator")
    public void getReservationWithInvalidParamterAndValidTokenOperator(String id) {
        reservationAPI.getReservationIdInvalidParamter(id);
    }

    @Given("Get reservation with valid parameter {} and invalid token operator")
    public void getReservationWithValidParameterAndInvalidTokenOperator(int id) {
        reservationAPI.getReservationIdInvalidToken(id);
    }
}
