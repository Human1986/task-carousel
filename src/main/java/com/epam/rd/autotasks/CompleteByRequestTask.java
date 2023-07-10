package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    public boolean isComplete;
    int value;

    @Override
    public void execute() {
        if (isComplete) {
            value = 1;
        }
    }

    @Override
    public boolean isFinished() {
        return value == 1;
    }

    public void complete() {
        isComplete = true;
    }
}
