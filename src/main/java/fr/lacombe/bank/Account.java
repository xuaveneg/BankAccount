package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;

import static fr.lacombe.bank.Operation.Type.*;

public class Account {
    private Amount amount;
    private List<Operation> operations = new ArrayList<>();

    public Account() {
        amount = Amount.amountOf(0);
        operations.add(new Operation(CREATION, amount));
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
        operations.add(new Operation(DEPOSIT, amount, this.amount));
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.add(amount.negativeValue());
        operations.add(new Operation(WITHDRAWAL, amount, this.amount));
    }

    public String operations() {
        StringBuilder operations = new StringBuilder();
        for (Operation deposit : this.operations) {
            if (!deposit.isCreation())
                operations.append('\n');
            operations.append(deposit);
        }
        return operations.toString();
    }
}
