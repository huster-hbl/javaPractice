package annotation_test;

import java.io.IOException;

public class MyTest {
    @Testable
    public static void m1(){
        System.out.println("is testable");
    }

    public static void m2(){
        System.out.println("is not testable");
    }

    @Testable
    public void m3() {
        throw new RuntimeException("Boom");
    }


    }


