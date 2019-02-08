package fr.lacombe.bank;

import java.util.Locale;
import java.util.Objects;

import static java.lang.Double.compare;

public class Amount {
    private final double value;

    private Amount(double value) {
        this.value = roundValue(value);
    }

    public static Amount amountOf(double value) {
        return new Amount(value);
    }

    Amount add(Amount amount) {
        double roundedValue = roundValue(amount.value + value);
        return Amount.amountOf(roundedValue);
    }

    private double roundValue(double value) {
        return Math.round(value * 100d) / 100d;
    }

    Amount negativeAmount() {
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
        return compare(amount.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
