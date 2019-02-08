package fr.lacombe.bank;

import java.util.Calendar;

public class Date {
    private final DateWithoutYear dateWithoutYear;
    private final Year year;

    Date(int year, int month, int day) {
        this.year = new Year(year);
        dateWithoutYear = new DateWithoutYear(month, day);
    }

    static Date today() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return new Date(year, month, day);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", dateWithoutYear, year);
    }
}
