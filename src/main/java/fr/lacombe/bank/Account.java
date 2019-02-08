package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Amount amount;
    private final Date creationDate;
    private List<Operation> deposits = new ArrayList<>();

    public Account() {
        amount = Amount.amountOf(0);
        creationDate = Date.today();
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
        deposits.add(new Operation(amount));
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.add(amount.negativeValue());
    }

    public String operations() {
        StringBuilder operations = new StringBuilder(String.format("creation;%s;;0.00", creationDate));
        for (Operation deposit : deposits)
            operations.append(deposit);
        return operations.toString();
    }
}
