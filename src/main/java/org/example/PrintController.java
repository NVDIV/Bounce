package org.example;

public class PrintController {
    private boolean dashTurn = true;

    public synchronized void printDash() {
        try {
            while (!dashTurn) {
                wait();
            }
            System.out.print("-");
            dashTurn = false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printPipe() {
        try {
            while (dashTurn) {
                wait();
            }
            System.out.print("|");
            dashTurn = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}