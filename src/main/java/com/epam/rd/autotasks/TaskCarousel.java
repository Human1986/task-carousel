package com.epam.rd.autotasks;

import java.util.LinkedList;
import java.util.List;

public class TaskCarousel {

    private final List<Task> tasks;
    private final int capacity;
    private int index = -1;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new LinkedList<>();
    }

    public boolean addTask(Task task) {
        int value = 1;
        if(task instanceof CountDownTask) value = ((CountDownTask) task).getValue();
        if(!task.isFinished() && !isFull() && value != 0) {
            return tasks.add(task);
        }
        return false;
    }

    public boolean execute() {

        if (!isEmpty()) {
            index++;
            if(index == tasks.size()) index = 0;
            Task task = tasks.get(index);

            task.execute();

            if(task.isFinished()) {
                tasks.remove(task);
                index--;
            }
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return tasks.size() == capacity;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

}
