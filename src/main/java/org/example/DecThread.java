package org.example;

public class DecThread extends Thread {
    private Counter counter;

    public DecThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.decrement();
        }
    }
}
