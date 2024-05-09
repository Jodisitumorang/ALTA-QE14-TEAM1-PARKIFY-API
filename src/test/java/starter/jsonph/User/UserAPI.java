package starter.jsonph.User;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;
import java.io.File;


public class UserAPI {
    public static String USER = Constants.BASE_URL+"/users";
    public static String GET = Constants.BASE_URL+"/users";
    public static String TOKEN_USER = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImpvZGl1c2VyMkBnbWFpbC5jb20iLCJleHAiOjE3MTQ5MDk2MDAsImlhdCI6MTcxNDg5ODgwMCwicm9sZSI6InVzZXIifQ.SRSueHqvBI1CbWvRmSXnQFOEQG3qRmXN-bNH4Oz531U";
    public static String TOKEN_INVALID = "saad";


    // Feature User
    // Method Post
    // POSITIVE
    @Step("Post create add a new user with valid json")
    public void postCreateUserValidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    // NEGATIVE
    @Step("Post create add a new user with invalid json")
    public void postCreateUserInvalidJson (File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

//  Get User
//    POSITIVE
    @Step ("Get user with valid token authorization user")
    public void getUserValidToken () {
        SerenityRest.given()
                .header("Authorization",TOKEN_USER);
    }

//    NEGATIVE
    @Step ("get user with invalid token authorization user ")
    public void getUserInvalidToken () {
        SerenityRest.given()
                .header("Authorization",TOKEN_INVALID);
    }


//    Put User
//    POSITIVE
    @Step ("Put user with valid body json and token user")
    public void putUserValidBodyJsonAndValidToken (File json) {
        SerenityRest.given()
                .header("Authorization",TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

//    NEGATIVE
    @Step ("Put user with invalid body json and valid token user")
    public void putUserInvalidBodyJsonAndValidToken (File json) {
        SerenityRest.given()
                .header("Authorization",TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step ("Put user with valid body json and invalid token user")
    public void putUserValidBodyJsonAndInvalidToken (File json) {
        SerenityRest.given()
                .header("Authorization",TOKEN_INVALID)
                .contentType(ContentType.JSON)
                .body(json);
    }


//    Delete User
//    POSITIVE
    @Step ("Delete user with valid token user")
    public void deleteUserWithValidToken () {
        SerenityRest.given().header("Authorization",TOKEN_USER);
    }

//    NEGATIVE
    @Step ("Delete user with invalid token user")
    public void deleteUserWithInvalidToken(){
        SerenityRest.given().header("Authorization",TOKEN_INVALID);
    }


}








