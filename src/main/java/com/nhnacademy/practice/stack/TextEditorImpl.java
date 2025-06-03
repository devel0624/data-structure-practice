package com.nhnacademy.practice.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class TextEditorImpl implements TextEditor{

    private final Logger logger = Logger.getLogger("TextEditor");
    private final StringBuilder buffer;
    private final Deque<Operation> undoStack;
    private final Deque<Operation> redoStack;

    public TextEditorImpl() {
        buffer = new StringBuilder();
        undoStack = new LinkedList<>();
        redoStack = new LinkedList<>();
    }


    public void type(int index, String string) {
        undoStack.push(new Operation(Method.INSERT, index, index + string.length(), string));
        redoStack.clear();
        buffer.insert(index, string);
    }

    public void type(String string) {
        type(buffer.length(), string);
    }

    public void delete(int start, int end) {
        String string = buffer.substring(start, end);
        undoStack.push(new Operation(Method.DELETE, start, end, string));
        buffer.delete(start, end);
    }

    public void undo() {
        try {
            Operation operation = undoStack.pop();
            redoStack.push(operation);
            operation.operateReverse();
        } catch (NoSuchElementException e){
            logger.log(Level.INFO, "Unavailable Undo");
        }
    }

    public void redo() {
        try {
            Operation operation = redoStack.pop();
            undoStack.push(operation);
            operation.operateForward();
        } catch (NoSuchElementException e){
            logger.log(Level.INFO, "Unavailable Redo");
        }
    }

    @Override
    public String toString() {
        return buffer.toString();
    }

    enum Method {
        INSERT,
        DELETE;
    }

    class Operation {
        Method method;
        int start;
        int end;
        String string;

        public Operation(Method method, int start, int end, String string) {
            this.method = method;
            this.start = start;
            this.end = end;
            this.string = string;
        }

        private void operateForward() {
            if (method.equals(Method.INSERT)) {
                buffer.insert(start, string);
            } else if (method.equals(Method.DELETE)) {
                buffer.delete(start, end);
            }
        }
        private void operateReverse() {
            if (method.equals(Method.INSERT)) {
                buffer.delete(start, end);
            } else if (method.equals(Method.DELETE)) {
                buffer.insert(start, string);
            }
        }
    }
}
