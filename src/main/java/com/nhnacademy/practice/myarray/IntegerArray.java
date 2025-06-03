package com.nhnacademy.practice.myarray;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class IntegerArray implements MyArray<Integer>{
    private int[] intArray;

    @Override
    public boolean add(Integer element) {
        return false;
    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean remove(Integer removeTarget) {
        return false;
    }

    @Override
    public int indexOf(Integer target) {
        return 0;
    }
}

