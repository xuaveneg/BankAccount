package fr.lacombe.bank.date;

public class Year {
    private final int year;

    Year(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%04d", year);
    }
}