package fr.lacombe.bank;

public class Operation {
    private final Amount amount;
    private Date date;

    public Operation(Amount amount) {
        this.amount = amount;
        date = Date.today();
    }

    @Override
    public String toString() {
        return String.format("\ndeposit;%s;%s;%s", date, amount, amount);
    }
}
