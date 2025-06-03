package com.nhnacademy.practice.myarray;

/**
 * @author : 이성준
 * @since : 1.0
 */


public interface MyArray<T> {
    boolean add(T element);
    T get(int index);
    boolean isEmpty();
    int size();
    boolean remove(T removeTarget);
    int indexOf(T target);
}
