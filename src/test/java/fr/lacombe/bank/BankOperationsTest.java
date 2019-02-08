package fr.lacombe.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankOperationsTest {

    @Test
    public void operations_should_give_account_creation_with_correct_date() {
        Account account = new Account();
        assertThat(account.operations()).isEqualTo("creation;08/02/2019;;0.00");
    }
}
