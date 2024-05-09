package starter.stepdef.Parking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parking.ParkingResponse;
import starter.jsonph.Parking.ParkingAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ParkingStepDef {

    @Steps
    ParkingAPI parkingAPI;

    @Given("Post create add a new parking with valid location {string}, city {string}, imageloc {string}")
    public void postCreateAddANewParkingWithValidLocationCityImageloc(String location, String city, String imageLoc) {
        File imageFile = new File(Constants.IMAGE_LOC+imageLoc);
        parkingAPI.postCreateAddANewParkingValidJson(location,city,imageFile);
    }
    @When("Send request post create add a new parking")
    public void sendRequestPostCreateAddANewParking() {
        SerenityRest.when().post(ParkingAPI.PARKING);
    }

    @And("Response body name parking should be {string}")
    public void responseBodyNameParkingShouldBe(String message) {
        SerenityRest.and().body(ParkingResponse.MESSAGE,equalTo(message));
    }
    @And("Validate add a new parking json schema {string}")
    public void validateAddANewParkingJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

//  NEGATIVE
    @Given("Post create add a new parking with invalid location {string}, city {string}, imageloc {string}")
    public void postCreateAddANewParkingWithInvalidLocationCityImageloc(String location, String city, String imageLoc) {
        File imageFile = new File(Constants.IMAGE_LOC+imageLoc);
        parkingAPI.postCreateAddANewParkingInvalidJson(location, city, imageFile);
    }
    @Given("Post create add a new parking with valid location {string}, city {string}, imageLoc {string}")
    public void postCreateAddANewParkingWithValidLocationCityImageLoc(String location, String city, String imageLoc) {
        File imageFile = new File(Constants.IMAGE_LOC+imageLoc);
        parkingAPI.postCreateAddANewParkingInvalidToken(location, city, imageFile);
    }
}
