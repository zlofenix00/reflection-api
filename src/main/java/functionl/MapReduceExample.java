package functionl;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExample {

    public static void main(String[] args) {
        Stream.of(
                new Student(18, "Ivan"),
                new Student(23, "Petr"),
                new Student(34, "Vasya"),
                new Student(45, "Sveta"),
                new Student(20, "Katya"),
                new Student(68, "Den"),
                new Student(101, "Kira")
        )
//                .parallel()
                .sequential() // просчет в один поток
                .map(Student::getAge)
//                .reduce(Math::max)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        Optional<Student> maybeStudent = Stream.of(
                        new Student(18, "Ivan"),
                        new Student(23, "Petr"),
                        new Student(34, "Vasya"),
                        new Student(45, "Sveta"),
                        new Student(20, "Katya"),
                        new Student(68, "Den"),
                        new Student(101, "Kira")
                )
                .sequential() // просчет в один поток
//                .flatMap(student -> student.getMarks().stream())
//                .map(mark -> )
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

        maybeStudent.map(Student::getAge)
//                .filter(age -> age > 25)
                .flatMap(age -> Optional.of(age * 2))
                .ifPresent(System.out::println);
    }
}
