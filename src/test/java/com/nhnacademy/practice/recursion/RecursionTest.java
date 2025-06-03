package com.nhnacademy.practice.recursion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : 이성준
 * @since : 1.0
 */


class RecursionTest {

    BaseConverter baseConverter;

    @BeforeEach
    void setUp() {
        baseConverter = BaseConverter.newInstance();
    }

    @Test
    void DecimalToBinary() {
        int decimal = 236234234;

        String actual = baseConverter.convert(decimal, Base.BINARY);

        String expected = Integer.toBinaryString(decimal);

        assertThat(actual, equalTo(expected));
    }
    @Test
    void DecimalToOctal() {
        int decimal = 1634123;

        String actual = baseConverter.convert(decimal, Base.OCTAL);

        String expected = Integer.toOctalString(decimal);

        assertThat(actual, equalTo(expected));
    }
    @Test
    void DecimalToHexadecimal() {
        int decimal = 121241243;

        String actual = baseConverter.convert(decimal, Base.HEXADECIMAL);

        String expected = Integer.toHexString(decimal);

        assertThat(actual, equalTo(expected));
    }
}
