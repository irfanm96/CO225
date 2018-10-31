public class Main {



    public static void main(String [] args){

        Ball.updateTime(0);
        Ball b1=new Ball(0,0,10,45,Ball.getTime());
        Ball b2=new Ball(4,4,100,45,Ball.getTime());

        b2.willCollide(b1);


    }



}
