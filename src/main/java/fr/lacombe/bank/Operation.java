package fr.lacombe.bank;

public class Operation {
    private Date date;

    public Operation() {
        date = Date.today();
    }

    @Override
    public String toString() {
        return String.format("\ndeposit;%s;23.43;23.43", date);
    }
}
