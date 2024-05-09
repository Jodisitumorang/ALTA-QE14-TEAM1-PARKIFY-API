package starter.jsonph.Reservation;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.Parking.LoginOperatorStepDef;
import starter.utils.Constants;

import java.io.File;

public class ReservationAPI {

    public static String RESERVATION = Constants.BASE_URL+"/reservation";
    public static String RESERVATION_ID = Constants.BASE_URL+"/reservation/{id}";
    public static String TOKEN_INVALID = "Bearer sdadasdsadas";

    @Step ("Post create reservation with valid body json and valid token operator")
    public void postCreateReservationValid(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ LoginOperatorStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Post create reservation with invalid body json and valid token operator")
    public void postReservationInvalidJson (File json){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ LoginOperatorStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post create reservation with valid body json and invali token operator")
    public void postReservationInvalidToken (File json){
        SerenityRest.given()
                .header("Authorization",TOKEN_INVALID)
                .contentType(ContentType.JSON)
                .body(json);
    }
//    Get All Reservation
//    Method GET
//    POSITIVE
    @Step("Get all reservation with valid token operator")
    public void getAllReservation (){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token);
    }

//    NEGATIVE
    @Step("Get all reservation with invalid token operator")
    public void getAllReservationInvalidToken (){
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID);
    }

//    Get Reservation Id
//    Method GET
//    POSITIVE
    @Step("Get reservation id with valid parameter id and valid token operator")
    public void getReservationIdValidParameter(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token)
                .pathParam("id", id);
    }
//    NEGATIVE
    @Step("Get reservation id with invalid parameter and valid token operator")
    public void getReservationIdInvalidParamter (String id){
        SerenityRest.given()
                .header("Authorization","Bearer "+LoginOperatorStepDef.token)
                .pathParam("id", id);
    }
    @Step("Get reservation id with valid parameter id and invalid token operator")
    public void getReservationIdInvalidToken(int id){
        SerenityRest.given()
                .header("Authorization",TOKEN_INVALID)
                .pathParam("id",id);
    }




}
