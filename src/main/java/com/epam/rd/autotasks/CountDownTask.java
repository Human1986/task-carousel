package com.epam.rd.autotasks;

public class CountDownTask implements Task {
    boolean isFinished;
    int value;

    public CountDownTask(int value) {
        if (value < 0) value = 0;
        if (getValue() == 0) isFinished = true;
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if (! isFinished()) value--;

    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }
}
