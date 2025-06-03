package com.nhnacademy.practice.stack;

/**
 * @author : 이성준
 * @since : 1.0
 */


public interface TextEditor {
    void type(int index, String string);

    void type(String string);

    void delete(int start, int end);

    void undo();

    void redo();
}
