package fr.lacombe.bank.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Operations implements Iterable<Operation> {
    private List<Operation> operations = new ArrayList<>();

    public void add(Operation operation) {
        operations.add(operation);
    }

    @Override
    public Iterator<Operation> iterator() {
        return operations.iterator();
    }

    @Override
    public void forEach(Consumer<? super Operation> action) {
        operations.forEach(action);
    }

    @Override
    public Spliterator<Operation> spliterator() {
        return operations.spliterator();
    }
}