package fr.lacombe.bank.date;

public class DateWithoutYear {
    private final Month month;
    private final Day day;

    DateWithoutYear(int month, int day) {
        this.month = new Month(month);
        this.day = new Day(day);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", day, month);
    }
}