package org.example;

public class PipeThread extends Thread {
    private PrintController controller;

    public PipeThread(PrintController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            controller.printPipe();
        }
    }
}
