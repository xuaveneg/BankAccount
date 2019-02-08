package fr.lacombe.bank;

public class Account {

    private Amount amount;

    public Account(Client client) {
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        if (this.amount != null) {
            this.amount = this.amount.add(amount);
        } else {
            this.amount = amount;
        }
    }
}
