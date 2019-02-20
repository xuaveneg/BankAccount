package fr.lacombe.bank.date;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DateTest {

    @Test
    @Parameters({"2018,12,25", "2019,2,8", "2020,6,29"})
    public void to_string_should_print_date(int year, int month, int day) {
        DateGeneratorFake dateGenerator = new DateGeneratorFake(new Date(year, month, day));
        String date = String.format("%02d/%02d/%04d", day, month, year);
        assertThat(dateGenerator.today().toString()).isEqualTo(date);
    }
}