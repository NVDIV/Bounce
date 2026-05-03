package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    private int counter = 0;
    private JTextField textField;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
        + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonRed = new JButton("Add RED ball");
        JButton buttonBlue = new JButton("Add BLUE balls");
        JButton buttonJoin = new JButton("Join demo");
        JButton buttonStop = new JButton("Stop");
        buttonRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas, BallType.RED);
                canvas.add(b);

                BallThread thread = new BallThread(b, canvas, BounceFrame.this, BallType.RED);
                thread.setPriority(Thread.MAX_PRIORITY);
                thread.start();
            }
        });
        buttonBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i = 0; i < 10; i++) {

                    Ball b = new Ball(canvas, BallType.BLUE);
                    canvas.add(b);

                    BallThread thread = new BallThread(b, canvas, BounceFrame.this, BallType.BLUE);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    thread.start();
                }
            }
        });
        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Thread(() -> {

                    Ball b = new Ball(canvas, BallType.RED);

                    SwingUtilities.invokeLater(() -> {
                        canvas.add(b);
                        canvas.repaint();
                    });

                    BallThread thread = new BallThread(b, canvas, BounceFrame.this, BallType.RED);
                    thread.setPriority(Thread.MAX_PRIORITY);
                    thread.start();

                    try {
                        thread.join();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("Red ball finished, continue main thread");

                }).start();
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonPanel.add(buttonRed);
        buttonPanel.add(buttonBlue);
        buttonPanel.add(buttonJoin);
        buttonPanel.add(buttonStop);
        content.add(buttonPanel, BorderLayout.SOUTH);
        textField = new JTextField("0", 5);
        buttonPanel.add(new JLabel("In hole: "));
        buttonPanel.add(textField);
    }

    public void incrementCounter(){
        counter++;

        SwingUtilities.invokeLater(() -> {
            textField.setText(String.valueOf(counter));
        });
    }
}
