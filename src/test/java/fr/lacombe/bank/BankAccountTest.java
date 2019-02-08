package fr.lacombe.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void depositAcceptanceTest() {
        Client client = new Client();
        Account account = new Account(client);
        Amount amount = Amount.valueOf(245.33);
        account.makeDeposit(amount);
        Assertions.assertThat(account.getAmount()).isEqualTo(amount);
    }
}
