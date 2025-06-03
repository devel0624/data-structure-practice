package com.nhnacademy.practice.stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : 이성준
 * @since : 1.0
 */


class StackTest {

    String start = "Start word";
    String append = "append word";
    String insert = "insert word";
    String beforeRedo = "before Redo";

    TextEditor textEditor;
    @BeforeEach
    void setUp() {
        textEditor = new TextEditorImpl();
    }

    @Test
    void typeStartWord() {
        textEditor.type(start);

        String expected = start;
        assertThat(textEditor.toString(), equalTo(expected));
    }

    @Test
    void typeAppendWord() {
        textEditor.type(start);
        textEditor.type(append);

        String expected = start.concat(append);

        assertThat(textEditor.toString(), equalTo(expected));
    }

    @Test
    void typeInsertWord() {
        textEditor.type(start);
        textEditor.type(append);
        textEditor.type(start.length(), insert);

        String expected = start.concat(insert).concat(append);

        assertThat(textEditor.toString(), equalTo(expected));
    }

    @Test
    void deleteWord() {
        textEditor.type(start);
        textEditor.type(append);
        textEditor.type(start.length(), insert);

        textEditor.delete(0, start.length());

        String expected = insert.concat(append);

        assertThat(textEditor.toString(), equalTo(expected));
    }

    @Test
    void undoDeleteWord() {
        textEditor.type(start);
        textEditor.type(append);
        textEditor.type(start.length(), insert);

        textEditor.delete(0, start.length());

        textEditor.undo();

        String expected = start.concat(insert).concat(append);

        assertThat(textEditor.toString(), equalTo(expected));
    }

    @Test
    void undoOverflow() {
        textEditor.type(start);
        textEditor.type(append);
        textEditor.type(start.length(), insert);

        textEditor.delete(0, start.length());

        assertDoesNotThrow(
                () -> {
                    textEditor.undo();
                    textEditor.undo();
                    textEditor.undo();
                    textEditor.undo();
                    textEditor.undo();
                }
        );

        assertThat(textEditor.toString(), emptyString());
    }

    @Test
    void redoAfterType() {
        textEditor.type(start);
        textEditor.type(append);
        textEditor.type(start.length(), insert);

        textEditor.delete(0, start.length());

        assertDoesNotThrow(
                () -> {
                    textEditor.undo();
                    textEditor.undo();
                    textEditor.redo();
                    textEditor.type(beforeRedo);
                    textEditor.redo();
                }
        );

        String expected = start.concat(insert).concat(append).concat(beforeRedo);

        assertThat(textEditor.toString(), equalTo(expected));
    }
}
