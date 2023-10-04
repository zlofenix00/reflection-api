package functionl;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int age;
    private String name;

    private List<Integer> marks = new ArrayList<>();

    public List<Integer> getMarks() {
        return marks;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
