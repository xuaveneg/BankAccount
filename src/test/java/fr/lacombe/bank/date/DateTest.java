package fr.lacombe.bank.date;

import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DateTest extends AbstractDateMockTest {

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void to_string_should_print_date(int year, int month, int day) {
        mockDateUtilToReturn(year, month, day);
        String date = String.format("%02d/%02d/%04d", day, month, year);
        Assertions.assertThat(Date.today().toString()).isEqualTo(date);
    }
}