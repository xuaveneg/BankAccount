package fr.lacombe.bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BankAccountTest {

    @Test
    @Parameters({"245.33", "42.57", "56.34"})
    public void make_deposit_on_empty_account_should_give_amount_to_account(double amountValue) {
        Client client = new Client();
        Account account = new Account(client);
        Amount amount = Amount.valueOf(amountValue);
        account.makeDeposit(amount);
        Assertions.assertThat(account.getAmount()).isEqualTo(amount);
    }
}
