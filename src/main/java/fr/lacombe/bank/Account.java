package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;

import static fr.lacombe.bank.Operation.Type.*;

public class Account {
    private Amount amount;
    private final Date creationDate;
    private List<Operation> deposits = new ArrayList<>();

    public Account() {
        amount = Amount.amountOf(0);
        creationDate = Date.today();
        deposits.add(new Operation(CREATION, amount));
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
        deposits.add(new Operation(DEPOSIT, amount, this.amount));
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.add(amount.negativeValue());
        deposits.add(new Operation(WITHDRAWAL, amount, this.amount));
    }

    public String operations() {
        StringBuilder operations = new StringBuilder();
        for (Operation deposit : deposits) {
            if (!deposit.isCreation())
                operations.append('\n');
            operations.append(deposit);
        }
        return operations.toString();
    }
}
