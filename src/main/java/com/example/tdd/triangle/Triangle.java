
package com.example.tdd.triangle;

public class Triangle {

    public String classify(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return "INVALIDO";
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "INVALIDO";
        }

        if (a == b && b == c) {
            return "EQUILATERO";
        }

        if (a == b || a == c || b == c) {
            return "ISOSCELES";
        }

        return "ESCALENO";
    }
}
