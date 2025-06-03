package com.nhnacademy.practice.queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

import com.nhnacademy.practice.queue.domain.Task;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author : 이성준
 * @since : 1.0
 */


class QueueTest {

    TaskProcessor taskProcessor;

    @BeforeEach
    void setUp() {
        taskProcessor = new TaskProcessorImpl();
    }

    @Test
    void addTask() {
        Task taskA = Mockito.mock(Task.class);
        Task taskB = Mockito.mock(Task.class);

        taskProcessor.addTask(taskA);
        taskProcessor.addTask(taskB);

        assertThat(taskProcessor.waitingListSize(), equalTo(2));
    }

    @Test
    void processOneTask() {
        Task task = Mockito.mock(Task.class);

        given(task.isFinished()).willReturn(true);

        taskProcessor.addTask(task);
        taskProcessor.process();

        then(task).should(atLeastOnce()).work();
    }

    @Test
    void processLog() {
        Task taskA = Mockito.mock(Task.class);
        Task taskB = Mockito.mock(Task.class);

        given(taskA.getName()).willReturn("A");
        given(taskB.getName()).willReturn("B");

        given(taskA.isFinished()).willReturn(true);
        given(taskB.isFinished()).willReturn(true);


        taskProcessor.addTask(taskA);
        taskProcessor.addTask(taskB);

        taskProcessor.process();

        String expected =
                taskA.getName() + "\n" +
                        taskB.getName() + "\n";

        assertThat(taskProcessor.getTaskLog(), equalTo(expected));
    }

    @Test
    void processTasks() {
        Task taskA = Mockito.mock(Task.class);
        Task taskB = Mockito.mock(Task.class);

        AtomicInteger aTaskRepeat = new AtomicInteger(3);
        AtomicInteger bTaskRepeat = new AtomicInteger(4);

        given(taskA.isFinished()).will(invocationOnMock -> aTaskRepeat.decrementAndGet() <= 0);
        given(taskB.isFinished()).will(invocationOnMock -> bTaskRepeat.decrementAndGet() <= 0);
        given(taskA.getName()).willReturn("A");
        given(taskB.getName()).willReturn("B");


        taskProcessor.addTask(taskB);
        taskProcessor.addTask(taskA);

        taskProcessor.process();

        String expected =
                taskB.getName() + "\n" +
                taskA.getName() + "\n" +
                taskB.getName() + "\n" +
                taskA.getName() + "\n" +
                taskB.getName() + "\n" +
                taskA.getName() + "\n" +
                taskB.getName() + "\n";

        then(taskA).should(times(3)).isFinished();
        then(taskB).should(times(4)).isFinished();
        assertThat(taskProcessor.getTaskLog(), equalTo(expected));
    }
}
