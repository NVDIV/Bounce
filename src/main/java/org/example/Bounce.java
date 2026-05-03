package org.example;

import javax.swing.*;

public class Bounce {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread t1 = new IncThread(counter);
        Thread t2 = new DecThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value = " + counter.getValue());

//        for (int i = 0; i < 100; i++) {
//
//            PrintController controller = new PrintController();
//
//            Thread t1 = new DashThread(controller);
//            Thread t2 = new PipeThread(controller);
//
//            t1.start();
//            t2.start();
//
//            try {
//                t1.join();
//                t2.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println();
//        }

//        BounceFrame frame = new BounceFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        System.out.println("Thread name = " +
//                Thread.currentThread().getName());
    }
}