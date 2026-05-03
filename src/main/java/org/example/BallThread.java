package org.example;

public class BallThread extends Thread {
    private Ball b;
    private BallCanvas canvas;
    private BounceFrame frame;

    public BallThread(Ball ball, BallCanvas canvas, BounceFrame frame, BallType type){
        this.b = ball;
        this.canvas = canvas;
        this.frame = frame;

        if(type == BallType.RED){
            this.setPriority(Thread.MAX_PRIORITY);
        } else {
            this.setPriority(Thread.MIN_PRIORITY);
        }
    }
    @Override
    public void run(){
        try{
            for(int i=1; i<10000; i++){
                b.move();
                System.out.println("Thread name = "

                + Thread.currentThread().getName());

                if (b.isInHole() == true) {
                    canvas.remove(b);
                    frame.incrementCounter();
                    break;
                }

                Thread.sleep(5);

            }
        } catch(InterruptedException ex){
        }
    }
}
