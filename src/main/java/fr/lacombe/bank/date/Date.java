package fr.lacombe.bank.date;

public class Date {
    private final DateWithoutYear dateWithoutYear;
    private final Year year;

    public Date(int year, int month, int day) {
        this.year = new Year(year);
        dateWithoutYear = new DateWithoutYear(month, day);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", dateWithoutYear, year);
    }
}
