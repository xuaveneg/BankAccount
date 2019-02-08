package fr.lacombe.bank;

public class Account {

    private Amount amount;
    private final Date creationDate;

    public Account() {
        amount = Amount.amountOf(0);
        creationDate = Date.today();
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.add(amount.negativeValue());
    }

    public String operations() {
        return String.format("creation;%s;;0.00", creationDate);
    }
}
