package fr.lacombe.bank;

import java.util.Objects;

public class Amount {
    private final double value;

    private Amount(double value) {
        this.value = value;
    }

    public static Amount valueOf(double value) {
        return new Amount(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Double.compare(amount.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }

    public Amount add(Amount amount) {
        return Amount.valueOf(this.value + amount.value);
    }
}
