package com.nhnacademy.practice.myarray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class IntegerArray implements MyArray<Integer>, Iterable<Integer> {
    private int[] intArray;

    private int cursor;

    public IntegerArray() {
        this.intArray = new int[0];
        this.cursor = 0;
    }

    @Override
    public boolean add(Integer element) {
        if (intArray.length == cursor) {
            expendArray();
        }
        this.intArray[cursor++] = element;
        return true;
    }

    @Override
    public Integer get(int index) {
        return intArray[index];
    }

    @Override
    public boolean isEmpty() {
        return intArray.length == 0;
    }

    @Override
    public int size() {
        return intArray.length;
    }

    @Override
    public int indexOf(Integer target) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Integer removeTarget) {
        for (int i = 0; i < intArray.length; i++) {
            if (Objects.equals(intArray[i], removeTarget)) {
                reduceArray(i);
                cursor--;
                return true;
            }
        }
        return false;
    }

    private void expendArray() {
        int[] integers = new int[intArray.length + 1];

        for (int i = 0; i < intArray.length; i++) {
            integers[i] = intArray[i];
        }

        this.intArray = integers;
    }

    private void reduceArray(int index) {
        int[] integers = new int[intArray.length - 1];
        for (int i = 0; i < index; i++) {
            integers[i] = intArray[i];
        }
        for (int i = index; i < intArray.length - 1; i++) {
            integers[i] = intArray[i + 1];
        }
        this.intArray = integers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Arrays.stream(intArray).iterator();
    }

    @Override
    public String toString() {
        return '{' + Arrays.toString(intArray) + '}';
    }
}

