package com.nhnacademy.practice.queue.domain;

/**
 * @author : 이성준
 * @since : 1.0
 */


public interface Task {
    void work();
    boolean isFinished();
    String getName();
}
