package com.example.tdd.triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    private final Triangle triangle = new Triangle();

    @ParameterizedTest
    @CsvSource({
            "3,4,5",
            "5,7,9"
    })
    void shouldClassifyScalene(int a, int b, int c) {
        assertEquals("ESCALENO", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "5,5,3",
            "5,3,5",
            "3,5,5"
    })
    void shouldClassifyIsosceles(int a, int b, int c) {
        assertEquals("ISOSCELES", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "5,5,5"
    })
    void shouldClassifyEquilateral(int a, int b, int c) {
        assertEquals("EQUILATERO", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "0,5,5",
            "5,0,5",
            "5,5,0"
    })
    void shouldReturnInvalidWhenOneSideIsZero(int a, int b, int c) {
        assertEquals("INVALIDO", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "-1,5,5",
            "5,-1,5",
            "5,5,-1"
    })
    void shouldReturnInvalidWhenOneSideIsNegative(int a, int b, int c) {
        assertEquals("INVALIDO", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "1,3,2",
            "2,1,3",
            "2,3,1",
            "3,1,2",
            "3,2,1"
    })
    void shouldReturnInvalidWhenSumEqualsThird(int a, int b, int c) {
        assertEquals("INVALIDO", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,4",
            "1,4,2",
            "2,1,4",
            "2,4,1",
            "4,1,2",
            "4,2,1"
    })
    void shouldReturnInvalidWhenSumLessThanThird(int a, int b, int c) {
        assertEquals("INVALIDO", triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0"
    })
    void shouldReturnInvalidWhenAllSidesAreZero(int a, int b, int c) {
        assertEquals("INVALIDO", triangle.classify(a, b, c));
    }
}
