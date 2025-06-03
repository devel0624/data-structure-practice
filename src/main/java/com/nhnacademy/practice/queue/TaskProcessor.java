package com.nhnacademy.practice.queue;

import com.nhnacademy.practice.queue.domain.Task;

/**
 * @author : 이성준
 * @since : 1.0
 */


public interface TaskProcessor {
    void addTask(Task a);

    void process();

    int waitingListSize();

    String getTaskLog();
}
