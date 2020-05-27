package annotation_test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestProcesser {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        for (Method m : Class.forName("annotation_test.MyTest").getMethods()) {
            if (m.isAnnotationPresent(Testable.class)) {
                m.invoke(null);
            } else {
                m.invoke(null);
            }
        }
    }
}
