package fr.lacombe.bank;

import junitparams.Parameters;
import org.junit.Test;

import java.util.Locale;

import static fr.lacombe.bank.Amount.amountOf;
import static org.assertj.core.api.Assertions.assertThat;

public class BankOperationsTest extends AbstractDateMockTest {

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void operations_should_give_account_creation_with_correct_date(int year, int month, int day) {
        mockDateUtilToReturn(year, month, day);
        Account account = new Account();
        String awaitedOperation = String.format("creation;%02d/%02d/%04d;;0.00", day, month, year);
        assertThat(account.operations()).isEqualTo(awaitedOperation);
    }

    @Test
    @Parameters({"2019,1,30", "2019,2,8", "2020,6,29"})
    public void operations_should_give_deposit_with_correct_date(int year, int month, int day) {
        mockDateUtilToReturn(2018, 12, 25);
        Account account = new Account();
        mockDateUtilToReturn(year, month, day);
        account.makeDeposit(amountOf(23.43));
        assertThat(account.operations()).isEqualTo("creation;25/12/2018;;0.00\n" +
                String.format("deposit;%02d/%02d/%02d;23.43;23.43", day, month, year));
    }

    @Test
    @Parameters({"23.43", "345.88", "4145.27"})
    public void operations_should_give_deposit_with_correct_amount(double amount) {
        mockDateUtilToReturn(2018,12,25);
        Account account = new Account();
        mockDateUtilToReturn(2019, 1, 30);
        account.makeDeposit(amountOf(amount));
        assertThat(account.operations()).isEqualTo("creation;25/12/2018;;0.00\n" +
                String.format(Locale.US,
                        "deposit;30/01/2019;%.2f;%.2f", amount, amount));
    }
}
