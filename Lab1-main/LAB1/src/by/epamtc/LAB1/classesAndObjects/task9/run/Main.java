package by.epamtc.LAB1.classesAndObjects.task9.run;

import by.epamtc.LAB1.classesAndObjects.task9.util.Ball;
import by.epamtc.LAB1.classesAndObjects.task9.util.Bucket;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball(10, Color.GREEN);
        Ball ball2 = new Ball(11, Color.BLUE);
        Ball ball3 = new Ball(12, Color.GREEN);
        Ball ball4 = new Ball(13, Color.GREEN);

        Bucket bucket = new Bucket(22);
        bucket.addBall(ball1);
        bucket.addBall(ball2);
        bucket.addBall(ball3);
        System.out.println(bucket.countBlue());
    }
}
