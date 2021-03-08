package annotations;

import java.lang.reflect.Method;
import java.util.List;

public class UseCaseTracker {
    public static void trackUserCases(Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case " + uc.id() + "\n" + uc.description());
            }
        }
    }

    public static void main(String[] args) {
        trackUserCases(PasswordUtils.class);
    }
}
