package annotation_test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class TestInheritable extends Base {
    public static void main(String[] args) {
        Class clazz = TestInheritable.class;
        System.out.println(clazz.isAnnotationPresent(Inheritable.class));
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }
}
