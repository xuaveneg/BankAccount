package fr.lacombe.bank.operation;

import fr.lacombe.bank.Amount;

public class OperationBalanceWithAmount extends OperationBalance {
    private final Amount amount;

    OperationBalanceWithAmount(Amount amount, Amount balance) {
        super(balance);
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s;%s", amount, balance);
    }
}
