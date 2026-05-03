package org.example;

import javax.swing.*;

public class Bounce {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {

            Thread t1 = new DashThread();
            Thread t2 = new PipeThread();

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        }

//        BounceFrame frame = new BounceFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        System.out.println("Thread name = " +
//                Thread.currentThread().getName());
    }
}