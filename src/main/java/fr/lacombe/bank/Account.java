package fr.lacombe.bank;

public class Account {

    private Amount amount;

    public Account() {
        amount = Amount.amountOf(0);
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
    }

    public void withdraw(Amount amount) {
        this.amount = amount.negativeValue();
    }
}
