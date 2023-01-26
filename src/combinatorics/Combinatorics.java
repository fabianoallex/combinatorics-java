package combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Combinatorics<T> {
    private final List<T> elements;
    private final int size;
    private final Predicate<List<T>> validator;

    private Combinatorics(Builder<T> builder) {
        this.elements = builder.elements;
        this.size = builder.size;
        this.validator = builder.validator;
    }

    public static <T> Builder<T> of(List<T> elements) {
        return new Builder<T>(elements);
    }

    public void forEachArrangement(Consumer<List<T>> callback) {
        List<T> array = new ArrayList<T>(size);
        forEachArrangementHelper(elements, array, 0, size, callback);
    }

    private void forEachArrangementHelper(List<T> elements, List<T> array, int index, int size, Consumer<List<T>> callback) {
        if (index == size) {
            if (validator == null || validator.test(array))
                callback.accept(array);
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            array.add(elements.get(i));
            forEachArrangementHelper(elements, array, index + 1, size, callback);
            array.remove(index);
        }
    }

    public void forEachPermutation(Consumer<List<T>> callback) {
        List<T> array = new ArrayList<T>(size);
        forEachPermutationHelper(elements, array, 0, size, callback);
    }

    private void forEachPermutationHelper(List<T> elements, List<T> array, int index, int size, Consumer<List<T>> callback) {
        if (index == size) {
            if (validator == null || validator.test(array))
                callback.accept(array);
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            if(!array.contains(elements.get(i))){
                array.add(elements.get(i));
                forEachPermutationHelper(elements, array, index + 1, size, callback);
                array.remove(index);
            }
        }
    }

    public void forEachCombination(Consumer<List<T>> callback) {
        List<T> array = new ArrayList<T>(size);
        forEachCombinationHelper(elements, array, 0, 0, size, callback);
    }

    private void forEachCombinationHelper(List<T> elements, List<T> array, int index, int start, int size, Consumer<List<T>> callback) {
        if (index == size) {
            if (validator == null || validator.test(array))
                callback.accept(array);
            return;
        }
        for (int i = start; i < elements.size(); i++) {
            array.add(elements.get(i));
            forEachCombinationHelper(elements, array, index + 1, i + 1, size, callback);
            array.remove(index);
        }
    }

    public static class Builder<T> {
        private final List<T> elements;
        private int size;
        private Predicate<List<T>> validator;

        private Builder(List<T> elements) {
            this.elements = elements;
            this.size = elements.size();
        }

        public Builder<T> withResultSize(int size) {
            this.size = size;
            return this;
        }

        public Builder<T> withFilter(Predicate<List<T>> validator) {
            this.validator = validator;
            return this;
        }

        public Combinatorics<T> build() {
            return new Combinatorics<T>(this);
        }
    }
}