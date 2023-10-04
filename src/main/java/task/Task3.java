package task;

import java.util.Map;

/**
 * Дана Map<String, Integer>. Найти сумму всех
 * значений. Длина ключей которых меньше 7
 * символов.
 */
public class Task3 {

    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = Map.of(
                "string1", 1,
                "strin2", 2,
                "string3", 3,
                "string4", 4,
                "strin5", 5
        );

        int result = stringIntegerMap.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();

        System.out.println(result);
    }
}
