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
public class GetAllReservationStepDef {

    @Steps
    ReservationAPI reservationAPI;

//    POSITIVE
    @Given("Get all reservation with valid token operator")
    public void getAllReservationWithValidTokenOperator() {
        reservationAPI.getAllReservation();
    }
    @When("Send request get all reservation")
    public void sendRequestGetAllReservation() {
        SerenityRest.when().get(ReservationAPI.RESERVATION);
    }

    @Then("Status code get all reservation should be {int}")
    public void statusCodeGetAllReservationShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Response body name all reservation {string}")
    public void responseBodyNameAllReservation(String message) {
        SerenityRest.and().body(ResponseReservation.MESSAGE,equalTo(message));
    }

    @And("Validate get reservation json schema {string}")
    public void validateGetReservationJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_RESERVATION+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get all reservation with invalid token operator")
    public void getAllReservationWithInvalidTokenOperator() {
        reservationAPI.getAllReservationInvalidToken();
    }
}
