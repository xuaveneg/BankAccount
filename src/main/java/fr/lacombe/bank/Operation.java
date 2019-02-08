package fr.lacombe.bank;

public class Operation {
    private final String label;
    private final Amount amount;
    private final Amount balance;
    private final Date date;

    public Operation(String withdrawal, Amount amount, Amount balance) {
        this.label = withdrawal;
        this.amount = amount;
        this.balance = balance;
        date = Date.today();
    }

    @Override
    public String toString() {
        return String.format("\n%s;%s;%s;%s", label, date, amount, balance);
    }
}
