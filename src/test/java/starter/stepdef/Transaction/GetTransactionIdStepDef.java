package starter.stepdef.Transaction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Transaction.TransactionAPI;

public class GetTransactionIdStepDef {

    @Steps
    TransactionAPI transactionAPI;

    @Given("Get transaction with valid parameter {} and valid token authorization")
    public void getTransactionWithValidParameterAndValidTokenAuthorization(int id) {
        transactionAPI.getTransactionValidData(id);
    }

    @When("Send request get transaction")
    public void sendRequestGetTransaction() {
        SerenityRest.when().get(TransactionAPI.TRANSACTION_ID);
    }


    @Given("Get transaction with invalid parameter {string} and token operator")
    public void getTransactionWithInvalidParameterAndTokenOperator(String id) {
        transactionAPI.getTransactionInvalidParameter(id);
    }

    @Given("Get transaction id with valid parameter {} and invalid token operator")
    public void getTransactionIdWithValidParameterAndInvalidTokenOperator(int id) {
        transactionAPI.getTransactionInvalidToken(id);
    }
}
