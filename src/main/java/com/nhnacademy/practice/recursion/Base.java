package com.nhnacademy.practice.recursion;

import java.util.function.Function;

/**
 * @author : 이성준
 * @since : 1.0
 */


public enum Base {
    BINARY(2, Integer::toBinaryString),
    OCTAL(8, Integer::toOctalString),
    HEXADECIMAL(16, Integer::toHexString);

    Base(int value, Function<Integer, String> function) {
        this.value = value;
        this.function = function;
    }


    private final Function<Integer, String> function;
    private final int value;

    public int getValue() {
        return value;
    }

    public String calculate(int decimal) {
        if (decimal < value){
            return function.apply(decimal % value);
        }
        return function.apply(decimal / value);
    }
}
