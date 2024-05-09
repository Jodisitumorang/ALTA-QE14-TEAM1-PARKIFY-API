package starter.stepdef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Login.LoginAPI;
import starter.jsonph.Login.LoginResponse;
import starter.utils.Constants;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;



public class PostLoginUserStepDef {

    @Steps
    LoginAPI loginAPI;

//    POSITIVE
    @Given("Create login user with valid body json {string}")
    public void createLoginUserWithValidBodyJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_Login+json);
        loginAPI.postCreateLoginUserWithValidBodyJson(jsonFile);
    }

    @And("Response body name should be {string}")
    public void responseBodyNameShouldBe(String message) {
        SerenityRest.and().body(LoginResponse.MESSAGE,equalTo(message));
    }

    @Given("Post create login user with invalid email body json {string}")
    public void postCreateLoginUserWithInvalidBodyJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_Login+json);
        loginAPI.postCreateLoginUserWithInvalidEmail(jsonFile);
    }

    @Given("Post create login user with invalid password body json {string}")
    public void postCreateLoginUserWithInvalidPasswordBodyJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_Login+json);
        loginAPI.postCreateLoginUserWithInvalidPassword(jsonFile);
    }
}
