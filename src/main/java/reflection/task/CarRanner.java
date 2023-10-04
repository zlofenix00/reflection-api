package reflection.task;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CarRanner {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Corolla");
        System.out.println(car);
        System.out.println(generateInsert(car));
    }

    private static String generateInsert(Car car){
        String template = "INSERT INTO %s.%S (%s) VALUES (%s);";
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();

        String fieldNames = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::name)
                .collect(Collectors.joining(", "));

        String fieldValues = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> getMethodName(car, field))
                .map(method -> {
                    try {
                        return method.invoke(car);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                      throw new RuntimeException(e);
                    }
                })
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(", "));
        return String.format(template, table.schema(), table.name(), fieldNames, fieldValues);
    }

    @NotNull
    private static Method getMethodName(Car car, Field field) {
        String name = field.getName();
        try {
            return car.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
