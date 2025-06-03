package com.nhnacademy.practice.recursion;

import java.util.function.Function;

/**
 * @author : 이성준
 * @since : 1.0
 */


public enum Base {
    BINARY(2, (x) -> null),
    OCTAL(8, (x) -> null),
    HEXADECIMAL(16, (x) -> null);

    Base(int value, Function<Integer, String> function) {
        // TODO document why this method is empty
    }

    public int getValue() {
        return 0;
    }

    public String calculate(int decimal) {
        return null;
    }
}
