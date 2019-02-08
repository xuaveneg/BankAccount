package fr.lacombe.bank;

public class Account {
    private Amount amount;
    private final Date creationDate;
    private Operation deposit;

    public Account() {
        amount = Amount.amountOf(0);
        creationDate = Date.today();
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
        deposit = new Operation(amount);
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.add(amount.negativeValue());
    }

    public String operations() {
        String operations = String.format("creation;%s;;0.00", creationDate);
        if (deposit != null)
            operations += deposit;
        return operations;
    }
}
