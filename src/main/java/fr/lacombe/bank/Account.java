package fr.lacombe.bank;

public class Account {

    private Amount amount;

    public Account(Client client) {
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = amount;
    }
}
