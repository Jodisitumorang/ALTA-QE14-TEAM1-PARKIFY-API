package starter.jsonph.Parkingslot;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;
import starter.stepdef.Parking.LoginOperatorStepDef;
import starter.utils.Constants;
import java.io.File;


public class ParkingSlotAPI {

    public static String PARKING = Constants.BASE_URL + "/parking";
    public static String PARKING_SLOT = Constants.BASE_URL + "/parkingslot";
    public static String PARKINGS_ID = Constants.BASE_URL+"/parkingslot/{id}";
    public static String PARKING_ID = Constants.BASE_URL+"/parking/{id}";
    public static String TOKEN_OPERATOR = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImpvZGlvcGVyYXRvcjJAZ21haWwuY29tIiwiZXhwIjoxNzE1MjM5MDk3LCJpYXQiOjE3MTUyMjgyOTcsInJvbGUiOiJvcGVyYXRvciJ9.DnGJKzVwzmI_RYOwH-NkWRlKKMhJE_3VSo3nGO_A76Q";
    public static String TOKEN_INVALID = "saadfsd";


//    Post Create Parking Slot
//    Method POST
//    POSITIVE
    @Step ("Post create parking slot with valid body json and valid token operator")
    public void postCreateParkingSlotValid (File json){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ LoginOperatorStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

//    NEGATIVE
    @Step ("Post create parking slot and invalid body json and valid token operator")
    public void postCreatParkingSlotInvalidBodyJson (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Post create parking slot with valid body json and invalid token operator")
    public void postCreateParkingSlotInvalidToken (File json){
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID)
                .contentType(ContentType.JSON)
                .body(json);
    }

//    Put Parking Slot
//    Method PUT
//    POSITIVE
    @Step("Put parking slot with valid parameter, valid body json and valid token operator")
    public void putParkingSlotValid (File json, int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginOperatorStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

//    NEGATIVE
    @Step("Put parking slot with invalid parameter, valid body json and valid token operator")
    public void putParkingSlotInvalidParameter (File json, String id){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Put parking slot with valid parameter, invalid body json and valid token operator")
    public void putParkingSlotInvalitBodyJson (File json, int id){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Put parking slot with valid parameter, valid body json, and invalid token operator")
    public void putParkingSlotInvalidToken (File json, int id){
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

//    Get All Parking Slot
//    Method GET
//    POSITIVE
    @Step ("Get all parking slot with valid token operator")
    public void getAllParkingSlotValid (){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token);
    }
    @Step("Get all parking slot with invalid token operator")
    public void getAllParkingSlotInvalidToken (){
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID);
    }

//    Delete parking slot
//    Method DELETE
//    POSITIVE
    @Step ("Delete parking slot with valid parameter and valid token operator")
    public void deleteParkingSlotValid (int id){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token)
                .pathParam("id",id);
    }
//    NEGATIVE
    @Step("Delete parking slot with invalid parameter and valid token operator")
    public void deleteParkingSlotInvalidParameter (String id){
        SerenityRest.given()
                .header("Authorization", "Bearer "+LoginOperatorStepDef.token)
                .pathParam("id", id);
    }
    @Step ("Delete parking slot with valid parameter and invalid token operator")
    public void deleteParkingSlotInvalidToken (int id){
        SerenityRest.given()
                .header("Authorization", TOKEN_INVALID)
                .pathParam("id", id);
    }




}
