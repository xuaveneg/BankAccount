package fr.lacombe.bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
@PrepareForTest({Date.class})
public class BankOperationsTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    private void mockDateUtilToReturn(int year, int month, int day) {
        PowerMockito.when(Date.today()).thenReturn(new Date(year, month, day));
    }

    @Before
    public void mockDateUtilClass() {
        PowerMockito.mockStatic(Date.class);
    }

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void operations_should_give_account_creation_with_correct_date(int year, int month, int day) {
        mockDateUtilToReturn(year, month, day);
        Account account = new Account();
        String awaitedOperation = String.format("creation;%2d/%2d/%4d;;0.00", day, month, year);
        assertThat(account.operations()).isEqualTo(awaitedOperation);
    }
}
