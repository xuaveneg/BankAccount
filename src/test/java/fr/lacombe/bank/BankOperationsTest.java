package fr.lacombe.bank;

import fr.lacombe.bank.date.Date;
import fr.lacombe.bank.date.DateGeneratorFake;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;

import java.util.Locale;

import static fr.lacombe.bank.Amount.amountOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BankOperationsTest {

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void operations_should_give_account_creation_with_correct_date(int year, int month, int day) {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(new Date(year, month, day));
        Account account = new Account(dateGenerator);
        String awaitedOperation = String.format("creation;%02d/%02d/%04d;;0.00", day, month, year);
        assertThat(account.operations()).isEqualTo(awaitedOperation);
    }

    @Test
    @Parameters({"2019,1,30", "2019,2,8", "2020,6,29"})
    public void operations_should_give_deposit_with_correct_date(int year, int month, int day) {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(
                new Date(2018, 12, 25),
                new Date(year, month, day)
        );
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(23.43));
        assertThat(account.operations()).isEqualTo("creation;25/12/2018;;0.00\n" +
                String.format("deposit;%02d/%02d/%02d;23.43;23.43", day, month, year));
    }

    @Test
    @Parameters({"23.43", "345.88", "4145.27"})
    public void operations_should_give_deposit_with_correct_amount(double amount) {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(
                new Date(2018, 12, 25),
                new Date(2019, 1, 30)
        );
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(amount));
        assertThat(account.operations()).isEqualTo("creation;25/12/2018;;0.00\n" +
                String.format(Locale.US,
                        "deposit;30/01/2019;%.2f;%.2f", amount, amount));
    }

    @Test
    public void operations_with_multiple_deposits_should_print_correctly() {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(
             new Date(2018, 12, 25),
            new Date(2019, 1, 30),
            new Date(2020, 4, 13)
        );
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(23.45));
        account.makeDeposit(amountOf(444.55));
        assertThat(account.operations()).isEqualTo("creation;25/12/2018;;0.00\n" +
                "deposit;30/01/2019;23.45;23.45\n" +
                "deposit;13/04/2020;444.55;468.00");
    }

    @Test
    public void operations_with_withdrawal_should_print_correctly() {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(
                new Date(2018, 12, 25),
                new Date(2019, 1, 30),
                new Date(2020, 4, 13)
        );
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(444.55));
        account.withdraw(amountOf(23.45));
        assertThat(account.operations()).isEqualTo("creation;25/12/2018;;0.00\n" +
                "deposit;30/01/2019;444.55;444.55\n" +
                "withdrawal;13/04/2020;23.45;421.10");
    }

    @Test
    public void multiple_operations_should_print_correctly() {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(
                new Date(2018, 6, 29),
                new Date(2018, 9, 3),
                new Date(2018, 11, 13),
                new Date(2019, 1, 30),
                new Date(2019, 4, 1),
                new Date(2019, 8, 24),
                new Date(2020, 12, 25),
                new Date(2021, 7, 14),
                new Date(2022, 10, 17)
        );
        Account account = new Account(dateGenerator);
        account.makeDeposit(amountOf(12.23));
        account.makeDeposit(amountOf(1.00));
        account.makeDeposit(amountOf(444.55));
        account.withdraw(amountOf(23.45));
        account.withdraw(amountOf(0.00));
        account.makeDeposit(amountOf(42.42));
        account.makeDeposit(amountOf(29.06));
        account.withdraw(amountOf(123.45));
        assertThat(account.operations()).isEqualTo("creation;29/06/2018;;0.00\n" +
                "deposit;03/09/2018;12.23;12.23\n" +
                "deposit;13/11/2018;1.00;13.23\n" +
                "deposit;30/01/2019;444.55;457.78\n" +
                "withdrawal;01/04/2019;23.45;434.33\n" +
                "withdrawal;24/08/2019;0.00;434.33\n" +
                "deposit;25/12/2020;42.42;476.75\n" +
                "deposit;14/07/2021;29.06;505.81\n" +
                "withdrawal;17/10/2022;123.45;382.36");
    }
}
