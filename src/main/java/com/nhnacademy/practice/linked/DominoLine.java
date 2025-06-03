package com.nhnacademy.practice.linked;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class DominoLine {

    Domino start;

    public void setStart(Domino start) {
        this.start = start;
    }

    public int size() {
        Domino d = start;
        int i = 1;
        for (; d.hasNext(); i++) {
            d = d.getNext();
        }
        return i;
    }

    public void topple() {
        start.topple();
    }

    public void topple(int order) {
        Domino d = start;
        for (int i = 1; i < order; i++) {
            d = d.getNext();
        }

        d.topple();
    }

}
