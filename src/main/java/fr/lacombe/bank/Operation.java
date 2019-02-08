package fr.lacombe.bank;

import static fr.lacombe.bank.Operation.Type.CREATION;

public class Operation {
    private final Type type;
    private final Date date;
    private final Amount amount;
    private final Amount balance;

    Operation(Type type, Amount amount, Amount balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        date = Date.today();
    }

    public Operation(Type type, Amount balance) {
        this.type = type;
        this.amount = null;
        this.balance = balance;
        date = Date.today();
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", type, date, amount == null ? "" : amount, balance);
    }

    public boolean isCreation() {
        return type == CREATION;
    }

    public enum Type {
        WITHDRAWAL,
        DEPOSIT, CREATION;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
}
