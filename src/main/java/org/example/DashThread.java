package org.example;

public class DashThread extends Thread {
    private PrintController controller;

    public DashThread(PrintController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            controller.printDash();
        }
    }
}
