package org.example;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y= 0;
    private int dx = 2;
    private int dy = 2;
    private boolean inHole = false;
    private Color color;
    private BallType type;

    public Ball(Component c, BallType type){
        this.canvas = c;
        this.type = type;

        if(type == BallType.RED){
            color = Color.RED;
        } else {
            color = Color.BLUE;
        }


        if (Math.random()<0.5){
            x = new
                    Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new
                    Random().nextInt(this.canvas.getHeight());
        }
    }
    public static void f(){
        int a = 0;
    }
    public void draw (Graphics2D g2){
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));
    }
    public void move(){
        x+=dx;
        y+=dy;

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        if ((x <= 0 && y <= 0) ||
                (x + XSIZE >= width && y <= 0) ||
                (x <= 0 && y + YSIZE >= height) ||
                (x + XSIZE >= width && y + YSIZE >= height)) {

            this.inHole = true;
            return;
        }

        if (x < 0 || x + XSIZE >= width) dx = -dx;
        if (y < 0 || y + YSIZE >= height) dy = -dy;

        this.canvas.repaint();
    }

    public boolean isInHole() {
        return inHole;
    }
}