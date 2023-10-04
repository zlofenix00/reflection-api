package functionl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");

//        Привет на for each
//        for (String string : strings) {
//            String value = string + string;
//            Integer intValue = Integer.valueOf(value);
//            if (intValue % 2 == 0){
//                System.out.println(intValue);
//            }
//        }

        strings.stream()
                .map(value -> value + value)
                .map(Integer::valueOf)
                .filter(value -> value % 2 == 0)
                .sorted()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66")
                .peek(System.out::println)
                .toList();

        IntStream.range(0, 10)
                .forEach(System.out::println);

        IntStream.iterate(0, value -> value +3)
                .skip(10)
                .limit(20)
                .forEach(System.out::println);

    }
}
