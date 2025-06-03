package com.nhnacademy.practice.linkedStruct;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.nhnacademy.practice.linked.Domino;
import com.nhnacademy.practice.linked.DominoLine;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : 이성준
 * @since : 1.0
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DominoTest {


    @Order(1)
    @Test
    void setUpDomino() {
        Domino start = new Domino();
        DominoLine line = new DominoLine();

        line.setStart(start);

        assertThat(start.isFallen(), equalTo(false));
        assertThat(line.size(),  equalTo(1));
    }

    @Order(2)
    @Test
    void setUpToppleDomino() {
        Domino start = new Domino();

        DominoLine line = new DominoLine();

        line.setStart(start);
        line.topple();

        assertThat(start.isFallen(), equalTo(true));
    }

    @Order(3)
    @Test
    void toppleThreeDominoes() {
        Domino start = new Domino();
        Domino second = new Domino();
        Domino third = new Domino();

        DominoLine line = new DominoLine();

        line.setStart(start);
        start.setNext(second);
        second.setNext(third);

        line.topple();

        assertThat(start.isFallen(), equalTo(true));
        assertThat(second.isFallen(), equalTo(true));
        assertThat(third.isFallen(), equalTo(true));
    }

    @Order(4)
    @Test
    void toppleSecondDomino() {
        Domino start = new Domino();
        Domino second = new Domino();
        Domino third = new Domino();

        DominoLine line = new DominoLine();

        line.setStart(start);
        start.setNext(second);
        second.setNext(third);

        line.topple(2);

        assertThat(start.isFallen(), equalTo(false));
        assertThat(second.isFallen(), equalTo(true));
        assertThat(third.isFallen(), equalTo(true));
    }
}