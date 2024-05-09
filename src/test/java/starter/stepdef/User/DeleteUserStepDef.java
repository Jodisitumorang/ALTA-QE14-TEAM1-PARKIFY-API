package starter.stepdef.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.User.UserAPI;

public class DeleteUserStepDef {

    @Steps
    UserAPI userAPI;

    @Given("Delete user with valid token user")
    public void deleteUserWithValidTokenUser() {
        userAPI.deleteUserWithValidToken();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().get(UserAPI.USER);
    }

    @Given("Delete user with invalid token user")
    public void deleteUserWithInvalidTokenUser() {
        userAPI.deleteUserWithInvalidToken();
    }
}
