package org.example;

public class PipeThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("|");
        }
    }
}
