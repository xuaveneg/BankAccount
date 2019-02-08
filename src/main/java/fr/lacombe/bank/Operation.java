package fr.lacombe.bank;

public class Operation {
    private final Amount amount;
    private final Amount balance;
    private final Date date;

    public Operation(Amount amount, Amount balance) {
        this.amount = amount;
        this.balance = balance;
        date = Date.today();
    }

    @Override
    public String toString() {
        return String.format("\ndeposit;%s;%s;%s", date, amount, balance);
    }
}
