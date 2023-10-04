package task;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Дан список целых чисел. Найти среднее всех
 * нечетных чисел делящихся на 5
 */
public class task1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 3, 4, 6, 7, 5, 15, 20, 25, 10);
        OptionalDouble optionalDouble = integers.stream()
                .filter(value -> value % 2 != 0)
                .filter(value -> value % 5 == 0)
                .mapToInt(Integer::intValue)
                .average();

        optionalDouble.ifPresent(System.out::println);
    }
}
