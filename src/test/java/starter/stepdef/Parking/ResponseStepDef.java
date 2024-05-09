package starter.stepdef.Parking;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class ResponseStepDef {


    @Then("Status code parking should be {int}")
    public void statusCodeParkingShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

}
