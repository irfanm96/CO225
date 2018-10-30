public class Main {



    public static void main(String [] args){

        Ball.updateTime(0);
        Ball b1=new Ball(0,1,100,0,Ball.getTime());
        Ball b2=new Ball(1,0,100,90,Ball.getTime());

        b2.willCollide(b1);


    }



}
