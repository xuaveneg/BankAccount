package fr.lacombe.bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@RunWith(JUnitParamsRunner.class)
@PrepareForTest(Date.class)
public class DateTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    public DateTest() {
    }

    private void mockDateUtilToReturn(int year, int month, int day) {
        PowerMockito.when(Date.today()).thenReturn(new Date(year, month, day));
    }

    @Before
    public void mockDateUtilClass() {
        PowerMockito.mockStatic(Date.class);
    }

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void mock_date_util_should_return_given_date(int year, int month, int day) {
        mockDateUtilToReturn(year, month, day);
        Assertions.assertThat(Date.today()).isEqualTo(new Date(year, month, day));
    }

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void to_string_should_print_date(int year, int month, int day) {
        mockDateUtilToReturn(year, month, day);
        String date = String.format("%2d/%2d/%4d", day, month, year);
        Assertions.assertThat(Date.today().toString()).isEqualTo(date);
    }
}