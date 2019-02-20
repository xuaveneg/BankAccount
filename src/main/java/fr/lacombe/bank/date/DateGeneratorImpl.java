package fr.lacombe.bank.date;

import java.util.Calendar;

public class DateGeneratorImpl implements DateGenerator {

    public Date today() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return new Date(year, month, day);
    }
}
