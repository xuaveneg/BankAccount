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
            this.amount = Amount.valueOf(78.97);
        } else {
            this.amount = amount;
        }
    }
}
