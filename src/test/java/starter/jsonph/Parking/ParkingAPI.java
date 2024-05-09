package starter.jsonph.Parking;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.Parking.LoginOperatorStepDef;
import starter.utils.Constants;
import java.io.File;


public class ParkingAPI {
    public static String PARKING = Constants.BASE_URL + "/parking";
    public static String PARKING_ID = Constants.BASE_URL+"/parking/{id}";
    public static String TOKEN_OPERATOR = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImpvZGlvcGVyYXRvcjJAZ21haWwuY29tIiwiZXhwIjoxNzE1MTA5NDE5LCJpYXQiOjE3MTUwOTg2MTksInJvbGUiOiJvcGVyYXRvciJ9.UTT2Gn4gpdzNqxjspwjIbyKNJlCr2S-CMEFywaB8u9g";
    public static String TOKEN_INVALID = "saad";
    public static String ID_USER = Constants.BASE_URL + "/users/{code}";
    public static String LOGIN = Constants.BASE_URL+"/login";


//    login operator
    @Step ("Create login user with valid email and password")
    public void postLoginOperator(File json) {
    SerenityRest.given()
            .contentType(ContentType.JSON)
            .body(json);
    }



//    Create Add a New Parking
//    Method Post
//    POSITIVE
    @Step ("Create add a new parking with valid body json")
    public void postCreateAddANewParkingValidJson (String location, String city, File imageLoc){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("location",location)
                .multiPart("city",city)
                .multiPart("imageloc",imageLoc);
    }

//    NEGATIVE
    @Step ("Create add a new parking with body json")
    public void postCreateAddANewParkingInvalidJson (String location, String city, File imageLoc){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("location", location)
                .multiPart("city", city)
                .multiPart("imageloc", imageLoc);
    }
    @Step ("Create add a new parking with valid body json and invalid token")
    public void postCreateAddANewParkingInvalidToken (String location, String city, File imageLoc){
        SerenityRest.given().log().all()
                .header("Authorization", TOKEN_INVALID)
                .contentType("multipart/form-data")
                .multiPart("location",location)
                .multiPart("city",city)
                .multiPart("imageloc",imageLoc);
    }

//    Get All Parking
//    Method GET
//    POSITIVE
    @Step ("Get all parking with valid token authorization operator")
    public void getAllParkingValidToken () {
        SerenityRest.given().header("Authorization", "Bearer " + LoginOperatorStepDef.token);
    }
//    NEGATIVE
    @Step ("Get all parking with invalid token authorization operator")
    public void getAllParkingInvalidToken () {
        SerenityRest.given().header("Authorization", TOKEN_INVALID);
    }

//    Put id
//    Method PUT
//    POSITIVE
    @Step("Put parking with valid parameter id, valid body json, and valid token authorization operator")
    public void putParkingValidData (int id,String location, String city, File imageLoc) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .pathParam("id", id)
                .contentType("multipart/form-data")
                .multiPart("location",location)
                .multiPart("city",city)
                .multiPart("imageloc",imageLoc);
    }

//    NEGATIVE
    @Step("Put parking with invalid parameter id, valid body json, and valid token authorization operator")
    public void putParkingInvalidParameter (String id,String location, String city, File imageLoc) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .pathParam("id", id)
                .contentType("multipart/form-data")
                .multiPart("location",location)
                .multiPart("city",city)
                 .multiPart("imageloc",imageLoc);
    }
    @Step("Put parking with valid parameter id, valid body json, and invalid token authorization operator")
    public void putParkingInvalidToken (int id,String location, String city, File imageLoc) {
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID)
                .pathParam("id", id)
                .contentType("multipart/form-data")
                .multiPart("location",location)
                .multiPart("city",city)
                .multiPart("imageloc",imageLoc);
    }

//    Get parking id
//    Method GET
//    POSITIVE
    @Step ("Get parking id with valid parameter and token operator")
    public void getParkingIdValidData (int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization",TOKEN_OPERATOR);
    }

//    NEGATIVE
    @Step ("Get parking id with invalid parameter and valid token operator")
    public void getParkingIdInvalidParameter (String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", TOKEN_OPERATOR);
    }
    @Step ("Get parking id with valid parameter and invalid token operator")
    public void getParkingIdInvalidToken (int id) {
        SerenityRest.given()
                .pathParam("id",id)
                .header("Authorization",TOKEN_INVALID);
    }


}