import java.lang.Math;


public class Main {


    public static void main(String[] args) {

        Ball.updateTime(0);
        Ball b1 = new Ball(0.0, 1.0, 10, 45, Ball.getTime(), "B1");
        Ball.updateTime(5);

        Ball b2 = new Ball(0.0, 1.0, 20, 45, Ball.getTime(), "B2");
        Ball.updateTime(5);

        b2.willCollide(b1);
        Ball b3 = new Ball(-10.0, 5.0, 3, 30, Ball.getTime(), "B3");

        Ball.updateTime(20);
        b2.willCollide(b3);



    }


}


class Ball {

    private double x;
    private double y;
    private double speed;
    private double angleOfSpeedWithX;
    private double addedTime;
    private static double time;
    private String name;

    public String getName() {
        return name;
    }

    public Ball(double x, double y, double speed, double angleOfSpeedWithX, double addedTime, String name) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angleOfSpeedWithX = angleOfSpeedWithX;
        this.addedTime = addedTime;
        this.name = name;
    }

     static void updateTime(double newTime) {
        time += newTime;
    }

    public static double getTime() {
        return time;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAngleOfSpeedWithX() {
        return angleOfSpeedWithX;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double getAddedTime() {
        return addedTime;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    private void setAddedTime(double addedTime) {
        this.addedTime = addedTime;
    }


    private void setCurrentCoordinates(Ball b1) {

        double vX = b1.getSpeed() * Math.cos(Math.toRadians(b1.getAngleOfSpeedWithX()));
        double vY = b1.getSpeed() * Math.sin(Math.toRadians(b1.getAngleOfSpeedWithX()));

        double newX = b1.getX() + (getTime() - b1.getAddedTime()) * vX;

        double newY = b1.getY() + (getTime() - b1.getAddedTime()) * vY;

        b1.setX(newX);
        b1.setY(newY);


    }

    public void willCollide(Ball b) {

        this.setCurrentCoordinates(this);
        this.setCurrentCoordinates(b);
        boolean check = this.checkCollision(this, b);

        if (check) {
            System.out.println(this.getName() + " and " + b.getName() + " will collide");
            b.setAddedTime(getTime());
            this.setAddedTime(getTime());
            return;
        }
        System.out.println(this.getName() + " and " + b.getName() + " won't collide");

    }


    private boolean checkCollision(Ball b1, Ball b2) {

        double x1 = b1.getX();
        double x2 = b2.getX();
        double y1 = b1.getY();
        double y2 = b2.getY();

        if ((x1 == x2) && (y1 == y2)) {
            return true;
        }
        return false;
    }


}
