package fr.lacombe.bank;

import fr.lacombe.bank.date.DateGenerator;
import fr.lacombe.bank.date.DateGeneratorImpl;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.lacombe.bank.Amount.amountOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BankAccountTest {

    private DateGenerator dateGenerator = new DateGeneratorImpl();

    @Test
    @Parameters({"245.33", "42.57", "56.34"})
    public void make_deposit_on_empty_account_should_give_amount_to_account(double amountValue) {
        Account account = new Account(dateGenerator);
        Amount amount = amountOf(amountValue);
        account.makeDeposit(amount);
        assertThat(account.hasBalance(amount)).isTrue();
    }

    @Test
    @Parameters({"53.54,78.97", "25.43,50.86", "87.66,113.09"})
    public void make_deposit_should_increase_account_amount(double addedAmountValue, double expectedAmountValue) {
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(25.43));
        account.makeDeposit(amountOf(addedAmountValue));
        assertThat(account.hasBalance(amountOf(expectedAmountValue))).isTrue();
    }

    @Test
    @Parameters({"245.33", "42.57", "56.34"})
    public void withdraw_on_empty_account_should_give_negative_amount_to_account(double amountValue) {
        Account account = new Account(dateGenerator);
        Amount amount = amountOf(amountValue);
        account.withdraw(amount);
        assertThat(account.hasBalance(amountOf(-amountValue))).isTrue();
    }

    @Test
    @Parameters({"53.54,78.97", "25.43,107.08", "87.66,44.85"})
    public void withdraw_should_decrease_account_amount(double withdrewAmountValue, double expectedAmountValue) {
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(132.51));
        account.withdraw(amountOf(withdrewAmountValue));
        assertThat(account.hasBalance(amountOf(expectedAmountValue))).isTrue();
    }
}
