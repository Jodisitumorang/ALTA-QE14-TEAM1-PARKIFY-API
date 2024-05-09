package starter.stepdef.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.User.UserAPI;
import starter.jsonph.User.UserResponse;
import starter.utils.Constants;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetUserStepDef {

    @Steps
    UserAPI userAPI;

//    POSITIVE
    @Given("Get user with valid token authorization user")
    public void getUserWithValidTokenAuthorizationUser() {
        userAPI.getUserValidToken();

    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(UserAPI.GET);
    }

    @And("Response body should be {} and {string}")
    public void responseBodyShouldBeAnd(int userId, String fullName) {
        SerenityRest.and()
                .body(UserResponse.USER_ID,equalTo(userId))
                .body(UserResponse.FULLNAME,equalTo(fullName));
    }

//  NEGATIVE
    @Given("Get user with invalid token authorization user")
    public void getUserWithInvalidTokenAuthorizationUser() {
        userAPI.getUserInvalidToken();
    }
}
