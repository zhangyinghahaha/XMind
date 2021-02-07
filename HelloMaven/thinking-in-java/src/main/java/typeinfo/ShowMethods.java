package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void showMethod(String className) {
        try {
            Class<?> c = Class.forName(className);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            for (Constructor ctor : constructors) {
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }

    public static void main(String[] args) {
        showMethod("typeinfo.ShowMethods");
    }
}
