package fr.lacombe.bank.date;

public class Day {
    private final int day;

    Day(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%02d", day);
    }
}