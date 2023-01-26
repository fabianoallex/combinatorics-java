import combinatorics.Combinatorics;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Arrangement of [a, b]");
        Combinatorics.of(Arrays.asList("a", "b"))
                .build()
                .forEachArrangement(System.out::println);

        System.out.println("Arrangement of [a, b] with result size 3");
        Combinatorics.of(Arrays.asList("a", "b"))
                .withResultSize(3)
                .build()
                .forEachArrangement(System.out::println);

        System.out.println("Arrangement of [1, 2, 3] with filter (sum == 11) and resulta size 5");
        Combinatorics.of(Arrays.asList(1, 2, 3))
                .withResultSize(4)
                .withFilter(integers -> integers.stream().mapToInt(Integer::intValue).sum() == 11)
                .build()
                .forEachArrangement(System.out::println);

        System.out.println("Arrangement of [true, false]");
        Combinatorics.of(Arrays.asList(true, false))
                .build()
                .forEachArrangement(System.out::println);

        System.out.println("Permutation of [\"x\", \"y\", \"z\"]");
        Combinatorics.of(Arrays.asList("x", "y", "z"))
                .build()
                .forEachPermutation(System.out::println);

        System.out.println("Permutation of [\"x\", \"y\", \"z\"] with result size 2");
        Combinatorics.of(Arrays.asList("x", "y", "z"))
                .withResultSize(2)
                .build()
                .forEachPermutation(System.out::println);

        System.out.println("Combination of [\"1\", \"2\", \"3\"]");
        Combinatorics.of(Arrays.asList("1", "2", "3"))
                .withResultSize(2)
                .build()
                .forEachCombination(System.out::println);
    }
}