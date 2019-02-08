package fr.lacombe.bank;

import static fr.lacombe.bank.Operation.Type.CREATION;

public class Operation {
    private final Type type;
    private final OperationState operationState;

    Operation(Type type, Amount amount, Amount balance) {
        this.type = type;
        operationState = new OperationState(Date.today(), new OperationBalanceWithAmount(amount, balance));
    }

    Operation(Type type, Amount balance) {
        this.type = type;
        operationState = new OperationState(Date.today(), new OperationBalance(balance));
    }

    @Override
    public String toString() {
        return String.format("%s;%s", type, operationState);
    }

    boolean isCreation() {
        return type == CREATION;
    }

    public enum Type {
        WITHDRAWAL,
        DEPOSIT, CREATION;

        @Override
        public String toString() {
            String name = this.name();
            return name.toLowerCase();
        }
    }
}
