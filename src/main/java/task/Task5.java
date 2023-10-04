package task;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Дан класс Person c полями firstName, lastName
 * age.
 * Вывести полное имя самого старшего человека, у
 * которого длина имени не превышает 15
 * символов
 */
public class Task5 {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Petr", "Petrov", 25),
                new Person("Sveta", "Svetikova", 33),
                new Person("Kate", "Ivanov", 25),
                new Person("Slava", "Slavikov", 18),
                new Person("Arni", "Kutuzov12346", 56)
        );

        people.stream()
                .filter(person -> person.getFullName().length() < 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);

        Map<Integer, List<String>> map = people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getFullName, toList())));

        System.out.println(map);
    }
}
