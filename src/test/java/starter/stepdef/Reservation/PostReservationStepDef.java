package starter.stepdef.Reservation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.regexp.RE;
import starter.jsonph.Reservation.ReservationAPI;
import starter.jsonph.Reservation.ResponseReservation;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostReservationStepDef {

    @Steps
    ReservationAPI reservationAPI;


    @Given("Post create reservation with valid body json {string} and valid token operator")
    public void postCreateReservationWithValidBodyJsonAndValidTokenOperator(String json) {
        File jsonFile = new File(Constants.REQ_BODY_RESERVATION+json);
        reservationAPI.postCreateReservationValid(jsonFile);
    }

    @When("Send request post reservation")
    public void sendRequestPostReservation() {
        SerenityRest.when().post(ReservationAPI.RESERVATION);
    }

    @Then("Status code post reservation should be {int}")
    public void statusCodePostReservationShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Response body name reservation {string}")
    public void responseBodyNameReservation(String message) {
        SerenityRest.and().body(ResponseReservation.MESSAGE,equalTo(message));
    }

    @And("Validate post reservation json schema {string}")
    public void validatePostReservationJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_RESERVATION+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @Given("Post create reservation with invalid body json {string} and valid token operator")
    public void postCreateReservationWithInvalidBodyJsonAndValidTokenOperator(String json) {
        File jsonFile = new File(Constants.REQ_BODY_RESERVATION+json);
        reservationAPI.postReservationInvalidJson(jsonFile);
    }

    @Given("Post create reservation with valid body json {string} and invalid token operator")
    public void postCreateReservationWithValidBodyJsonAndInvalidTokenOperator(String json) {
        File jsonFile = new File(Constants.REQ_BODY_RESERVATION+json);
        reservationAPI.postReservationInvalidToken(jsonFile);
    }
}
