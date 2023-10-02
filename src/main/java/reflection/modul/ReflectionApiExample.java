package reflection.modul;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.*;

public class ReflectionApiExample {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = new User(25L, "Ivanov");
//
//        Class<? extends User> userClass = user.getClass();
//        Class<User> userClass1 = User.class;
//        System.out.println(userClass1 == userClass);

        testConstructor();
//        testFields(user);
        testMethods(user);
    }

    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = User.class.getConstructor(Long.class, String.class);
        User petr = constructor.newInstance(5L, "Petr");
        System.out.println(petr);
    }

    private static void testMethods(@NotNull User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Method method = user.getClass().getDeclaredMethod("getName");
//        System.out.println(method.invoke(user));

        Method method = user.getClass().getDeclaredMethod("setName", String.class);
        method.invoke(user, "Svata");
        System.out.println(user);
    }

    private static void testFields(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getSuperclass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object o = declaredField.get(object);
            System.out.println(declaredField.getModifiers());
            System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
            System.out.println(o);
        }
    }

    private class Test1{

    }

    private static class Test3{

    }

    private enum Test2{
        ONE, TWO
    }
}
