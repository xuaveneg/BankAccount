package fr.lacombe.bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
@PrepareForTest({DateUtil.class})
public class BankOperationsTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    private void mockDateUtilToReturn(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        PowerMockito.when(DateUtil.today()).thenReturn(calendar.getTime());
    }

    @Before
    public void mockDateUtilClass() {
        PowerMockito.mockStatic(DateUtil.class);
    }


    @Test
    @Parameters({"2018,12,25","2019,2,8","2020,6,29"})
    public void mock_date_util_should_return_given_date(int year, int month, int day) {
        mockDateUtilToReturn(year, month, day);
        Calendar awaitedTime = Calendar.getInstance();
        awaitedTime.set(year, month, day);
        assertThat(DateUtil.today()).isEqualTo(awaitedTime.getTime());
    }

    @Test
    public void operations_should_give_account_creation_with_correct_date() {
        Account account = new Account();
        assertThat(account.operations()).isEqualTo("creation;08/02/2019;;0.00");
    }

}
