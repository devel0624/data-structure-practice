package com.nhnacademy.practice.linked;

import java.util.Objects;
import java.util.Optional;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class Domino {

    private Domino next;
    private boolean isFallen;

    public void setNext(Domino next) {
        this.next = next;
    }

    public void topple() {
        if (!isFallen) {
            isFallen = true;
            Optional.ofNullable(next).ifPresent(Domino::topple);
        }
    }

    public boolean isFallen() {
        return isFallen;
    }

    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    public Domino getNext() {
        return next;
    }
}
