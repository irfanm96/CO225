import java.lang.Math;

public class Ball {

    private double x;
    private double y;
    private double speed;
    private double angleOfSpeedWithX;
    private double addedTime;
    public static double time;


    public Ball(double x, double y, double speed, double angleOfSpeedWithX, double addedTime) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angleOfSpeedWithX = angleOfSpeedWithX;
        this.addedTime = addedTime;
    }

    public static void updateTime(double newTime) {
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
//
//        double angleR = this.calculateRelativeVelocityAngle(this, b);
//        double angleC = this.calculateGradientAngle(this, b);
        boolean check = this.checkCollision(this, b);

        if (check) {
            System.out.println("collide");
            b.setAddedTime(getTime());
            this.setAddedTime(getTime());
            return;
        }

        System.out.println("will Not collide");
    }

//    private double calculateRelativeVelocityAngle(Ball b1, Ball b2) {
//
//        //stop b1
//        double ang1 = b1.getAngleOfSpeedWithX();
//        double ang2 = b2.getAngleOfSpeedWithX();
//
//        double vH = (b2.getSpeed() * Math.cos(Math.toRadians(ang2))) - (b1.getSpeed() * Math.cos(Math.toRadians(ang1)));
//        double vV = (b2.getSpeed() * Math.sin(Math.toRadians(ang2))) - (b1.getSpeed() * Math.sin(Math.toRadians(ang1)));
//
//        if (vH == 0) {
//            if (vV == 0) {
//                return 0;
//            }
//            if (vV > 0) {
//                return 90.0;
//            }
//            return -90.0;
//        }
//
//        return Math.toDegrees(Math.atan(vV / vH));
//
//    }

//    private double calculateGradientAngle(Ball b1, Ball b2) {
//
//
//        double y = (b1.getY() - b2.getY());
//        double x = (b1.getX() - b2.getX());
//
//        if (x == 0) {
//            if (y == 0) {
//                return 0.0;
//            }
//            if (y > 0) {
//                return 90.0;
//            }
//            return -90.0;
//        }
//
//
//        double gradient = y / x;
//
//        return Math.toDegrees(Math.atan(gradient));
//
//
//    }

    private boolean checkCollision(Ball b1, Ball b2) {

        double x1=b1.getX();
        double x2=b2.getX();
        double y1=b1.getY();
        double y2=b2.getY();

        if ((x1==x2) && (y1==y2)) {
            return true;
        }
        return false;
    }


}
