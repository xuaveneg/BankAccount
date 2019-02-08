package fr.lacombe.bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Param;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.lacombe.bank.Amount.amountOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BankAccountTest {

    @Test
    @Parameters({"245.33", "42.57", "56.34"})
    public void make_deposit_on_empty_account_should_give_amount_to_account(double amountValue) {
        Account account = new Account();
        Amount amount = amountOf(amountValue);
        account.makeDeposit(amount);
        assertThat(account.getAmount()).isEqualTo(amount);
    }

    @Test
    @Parameters({"53.54,78.97", "25.43,50.86", "87.66,113.09"})
    public void make_deposit_should_increase_account_amount(double addedAmountValue, double expectedAmountValue) {
        Account account = new Account();
        account.makeDeposit(amountOf(25.43));
        account.makeDeposit(amountOf(addedAmountValue));
        assertThat(account.getAmount()).isEqualTo(amountOf(expectedAmountValue));
    }

    @Test
    @Parameters({"245.33", "42.57", "56.34"})
    public void withdraw_on_empty_account_should_give_negative_amount_to_account(double amountValue) {
        Account account = new Account();
        Amount amount = amountOf(amountValue);
        account.withdraw(amount);
        assertThat(account.getAmount()).isEqualTo(amountOf(-amountValue));
    }

    @Test
    @Parameters({"53.54,78.97", "25.43,107.08", "87.66,44.85"})
    public void withdraw_should_decrease_account_amount(double withdrewAmountValue, double expectedAmountValue) {
        Account account = new Account();
        account.makeDeposit(amountOf(132.51));
        account.withdraw(amountOf(withdrewAmountValue));
        assertThat(account.getAmount()).isEqualTo(amountOf(expectedAmountValue));
    }
}
