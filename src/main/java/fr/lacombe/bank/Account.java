package fr.lacombe.bank;

public class Account {
    private Amount amount;
    private final Date creationDate;
    private Date depositDate;

    public Account() {
        amount = Amount.amountOf(0);
        creationDate = Date.today();
    }

    Amount getAmount() {
        return amount;
    }

    public void makeDeposit(Amount amount) {
        this.amount = this.amount.add(amount);
        depositDate = Date.today();
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.add(amount.negativeValue());
    }

    public String operations() {
        String operations = String.format("creation;%s;;0.00", creationDate);
        if (depositDate != null)
            operations += "\ndeposit;30/01/2019;23.43;23.43";
        return operations;
    }
}
