package fr.lacombe.bank;

import java.util.Locale;
import java.util.Objects;

public class Amount {
    private final double value;

    private Amount(double value) {
        this.value = value;
    }

    public static Amount amountOf(double value) {
        return new Amount(value);
    }

    Amount add(Amount amount) {
        return Amount.amountOf(Math.round((this.value + amount.value) * 100d) / 100d);
    }

    Amount negativeValue() {
        return amountOf(-value);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.2f", value);
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

}
