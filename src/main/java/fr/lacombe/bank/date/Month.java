package fr.lacombe.bank.date;

public class Month {
    private final int month;

    Month(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return String.format("%02d", month);
    }
}