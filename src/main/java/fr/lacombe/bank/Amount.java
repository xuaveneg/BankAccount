package fr.lacombe.bank;

import java.util.Locale;
import java.util.Objects;

import static java.lang.Double.compare;

public class Amount {
    private final int cents;

    private Amount(int cents) {
        this.cents = cents;
    }

    static Amount amountOf(double value) {
        return new Amount(roundValue(value));
    }

    Amount add(Amount amount) {
        return new Amount(amount.cents + cents);
    }

    private static int roundValue(double value) {
        return new Double(value * 100d).intValue();
    }

    Amount negativeAmount() {
        return new Amount(-cents);
    }

    @Override
    public String toString() {
        int positiveCents = Math.abs(cents);
        return String.format(Locale.US, "%d.%02d", cents / 100, positiveCents % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return compare(amount.cents, cents) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }
}
