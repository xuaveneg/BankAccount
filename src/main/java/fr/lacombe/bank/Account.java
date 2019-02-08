package fr.lacombe.bank;

import static fr.lacombe.bank.Operation.Type.*;

public class Account {
    private final Operations operations = new Operations();
    private Amount balance;

    public Account() {
        balance = Amount.amountOf(0);
        operations.add(new Operation(CREATION, balance));
    }

    boolean hasBalance(Amount balanceExpected) {
        return balance.equals(balanceExpected);
    }

    public void makeDeposit(Amount amount) {
        balance = balance.add(amount);
        operations.add(new Operation(DEPOSIT, amount, balance));
    }

    public void withdraw(Amount amount) {
        Amount negativeAmount = amount.negativeAmount();
        balance = balance.add(negativeAmount);
        operations.add(new Operation(WITHDRAWAL, amount, balance));
    }

    public String operations() {
        StringBuilder statement = new StringBuilder();
        for (Operation deposit : operations) {
            appendOperationInStatement(statement, deposit);
        }
        return statement.toString();
    }

    private void appendOperationInStatement(StringBuilder statement, Operation deposit) {
        if (!deposit.isCreation())
            statement.append('\n');
        statement.append(deposit);
    }
}
