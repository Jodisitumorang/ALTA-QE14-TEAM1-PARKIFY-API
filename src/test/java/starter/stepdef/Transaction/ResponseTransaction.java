package starter.stepdef.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.jsonph.Transaction.TransactionResponse;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponseTransaction {


    @Then("Status code transaction should be {int}")
    public void statusCodeTransactionShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Response body name transaction {string}")
    public void responseBodyNameTransaction(String message) {
        SerenityRest.and().body(TransactionResponse.MESSAGE,equalTo(message));
    }
    @And("Validate transaction json schema {string}")
    public void validatePostTransactionJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_TRANSACTION+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}
