package org.example;

import java.util.stream.IntStream;

@FunctionalInterface
interface MyInterface{

    // абстрактный метод
    double getPiValue();
}


public class Main {


    public static void main(String[] args) {
        MyInterface ref;

        // лямбда-выражение
        ref = () -> 3.1415;

        System.out.println("Value of Pi = " + ref.getPiValue());

        long count = IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter(z -> z > 0).count();
        System.out.println(count);


    }
}