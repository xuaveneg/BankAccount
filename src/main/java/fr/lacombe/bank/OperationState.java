package fr.lacombe.bank;

public class OperationState {
    private final Date date;
    private final OperationBalance operationBalance;

    OperationState(Date date, OperationBalance operationBalance) {
        this.date = date;
        this.operationBalance = operationBalance;
    }

    @Override
    public String toString() {
        return String.format("%s;%s", date, operationBalance);
    }

}