package fr.lacombe.bank;

public class OperationBalance {
    protected final Amount balance;

    OperationBalance(Amount balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format(";%s", balance);
    }
}