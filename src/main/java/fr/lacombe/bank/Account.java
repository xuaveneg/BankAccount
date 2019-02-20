package fr.lacombe.bank;

import fr.lacombe.bank.date.DateGenerator;
import fr.lacombe.bank.operation.Operation;
import fr.lacombe.bank.operation.Operations;

import static fr.lacombe.bank.operation.Operation.Type.*;

public class Account {
    private final Operations operations = new Operations();
    private Amount balance;
    private DateGenerator dateGenerator;

    public Account(DateGenerator dateGenerator) {
        this.dateGenerator = dateGenerator;
        balance = Amount.amountOf(0);
        operations.add(new Operation(CREATION, balance, dateGenerator.today()));
    }

    boolean hasBalance(Amount balanceExpected) {
        return balance.equals(balanceExpected);
    }

    public void makeDeposit(Amount amount) {
        balance = balance.add(amount);
        operations.add(new Operation(DEPOSIT, amount, balance, dateGenerator.today()));
    }

    public void withdraw(Amount amount) {
        Amount negativeAmount = amount.negativeAmount();
        balance = balance.add(negativeAmount);
        operations.add(new Operation(WITHDRAWAL, amount, balance, dateGenerator.today()));
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
