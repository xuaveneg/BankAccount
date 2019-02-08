package fr.lacombe.bank;

import java.util.Objects;

public class Amount {
    private final double v;

    public Amount(double v) {
        this.v = v;
    }

    public static Amount valueOf(double v) {
        return new Amount(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Double.compare(amount.v, v) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}
