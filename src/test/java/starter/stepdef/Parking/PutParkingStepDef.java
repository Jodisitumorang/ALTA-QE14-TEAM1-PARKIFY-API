package starter.stepdef.Parking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Parking.ParkingAPI;
import starter.utils.Constants;

import java.io.File;

public class PutParkingStepDef {

    @Steps
    ParkingAPI parkingAPI;

    @Given("Put parking with valid parameter id {}, valid json location {string}, city {string}, imageloc {string} and valid authorization operator")
    public void putParkingWithValidParameterIdValidJsonLocationCityImagelocAndValidAuthorizationOperator(int id, String location, String city, String imageLoc) {
        File imageFile = new File(Constants.IMAGE_LOC+imageLoc);
        parkingAPI.putParkingValidData(id,location,city,imageFile);
    }
    @When("Send request put parking")
    public void sendRequestPutParking() {
        SerenityRest.when().put(ParkingAPI.PARKING_ID);
    }
    @And("Validate put parking json schema {string}")
    public void validatePutParkingJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_PARKING+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Put parking with invalid parameter id {string}, valid json location {string}, city {string}, imageloc {string} and valid authorization operator")
    public void putParkingWithInvalidParameterIdValidJsonLocationCityImagelocAndValidAuthorizationOperator(String id, String location, String city, String imageLoc) {
        File imagaFile = new File(Constants.IMAGE_LOC+imageLoc);
        parkingAPI.putParkingInvalidParameter(id,location,city,imagaFile);
    }


    @Given("Put parking with valid parameter {}, valid location {string}, city {string}, imageLoc {string}")
    public void putParkingWithInvalid(int id, String location, String city, String imageLoc) {
        File imageFile = new File(Constants.IMAGE_LOC+imageLoc);
        parkingAPI.putParkingInvalidToken(id,location,city,imageFile);
    }


}
