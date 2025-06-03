package com.nhnacademy.practice.queue;

import com.nhnacademy.practice.queue.domain.Task;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : 이성준
 * @since : 1.0
 */


public class TaskProcessorImpl implements TaskProcessor {

    private final Queue<Task> tasks;

    private final StringBuilder taskLog;
    public TaskProcessorImpl() {
        this.tasks = new LinkedList<>();
        this.taskLog = new StringBuilder();
    }

    @Override
    public void addTask(Task a) {
        tasks.add(a);
    }

    @Override
    public void process() {
        while (!tasks.isEmpty()) {
            Task task = tasks.poll();
            task.work();
            taskLog.append(task.getName()).append("\n");

            if (!task.isFinished()) {
                tasks.add(task);
            }
        }
    }

    @Override
    public int waitingListSize() {
        return tasks.size();
    }

    @Override
    public String getTaskLog() {
        return taskLog.toString();
    }
}
