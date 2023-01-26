# combinatorics-java

## Exemplo no main

````java
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
                .withFilter((List<Integer> result) -> result.stream().mapToInt(Integer::intValue).sum() == 11)
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
````

Resultado

````java
Arrangement of [a, b]
[a, a]
[a, b]
[b, a]
[b, b]
Arrangement of [a, b] with result size 3
[a, a, a]
[a, a, b]
[a, b, a]
[a, b, b]
[b, a, a]
[b, a, b]
[b, b, a]
[b, b, b]
Arrangement of [1, 2, 3] with filter (sum == 11) and resulta size 5
[2, 3, 3, 3]
[3, 2, 3, 3]
[3, 3, 2, 3]
[3, 3, 3, 2]
Arrangement of [true, false]
[true, true]
[true, false]
[false, true]
[false, false]
Permutation of ["x", "y", "z"]
[x, y, z]
[x, z, y]
[y, x, z]
[y, z, x]
[z, x, y]
[z, y, x]
Permutation of ["x", "y", "z"] with result size 2
[x, y]
[x, z]
[y, x]
[y, z]
[z, x]
[z, y]
Combination of ["1", "2", "3"]
[1, 2]
[1, 3]
[2, 3]
````
