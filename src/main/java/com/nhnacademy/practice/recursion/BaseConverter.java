package com.nhnacademy.practice.recursion;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class BaseConverter {

    protected BaseConverter() {
    }

    public static BaseConverter newInstance() {
        return new BaseConverter();
    }

    public String convert(int decimal, Base base) {
        String calculate = base.calculate(decimal);

        if (decimal < base.getValue()) {
            return calculate;
        }
        return calculate + convert(decimal % base.getValue(), base);
    }
}
