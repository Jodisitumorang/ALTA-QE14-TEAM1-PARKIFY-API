package starter.stepdef.User;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.User.UserAPI;
import starter.utils.Constants;

import java.io.File;

public class PutUserStepDef {

    @Steps
    UserAPI userAPI;

//    POSITIVE
    @Given("Put user with valid body json {string} and valid token authorization user")
    public void putUserWithValidBodyJsonAndValidTokenAuthorizationUser(String json) {
        File jsonFile = new File(Constants.REQ_BODY_USER+json);
        userAPI.putUserValidBodyJsonAndValidToken(jsonFile);
    }

    @When("Send request put user")
    public void sendRequestPutUser() {
        SerenityRest.when().put(UserAPI.USER);
    }

    @Given("Put user with invalid body json {string} and valid token user")
    public void putUserWithInvalidBodyJsonAndValidTokenUser(String json) {
        File jsonFile = new File(Constants.REQ_BODY_USER+json);
        userAPI.putUserInvalidBodyJsonAndValidToken(jsonFile);
    }

    @Given("Put user with valid body json {string} and invalid token user")
    public void putUserWithValidBodyJsonAndInvalidTokenUser(String json) {
        File jsonFile = new File(Constants.REQ_BODY_USER+json);
        userAPI.putUserValidBodyJsonAndInvalidToken(jsonFile);
    }


}
