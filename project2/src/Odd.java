import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Odd extends  Thread implements test {
    private  int start;
    private  int end;
    private  static Set<Integer> s =new TreeSet<Integer>();
    private   Set<Integer> myOdds =new TreeSet<Integer>();
    private  static  int numOfThreads=4;
    private  static  int [] array= {1,2,3,4,5,6};

    private Odd(int start,int end ){
        this.start=start;
        this.end=end;
    }

    @Override
    public void hellow() {
        System.out.println();
    }

    @Override
    public void hi() {
        System.out.println();
    }

    public  void run(){

        for (int i=start ; i<end ; i++){
            if(array[i]%2==1){
                myOdds.add(array[i]);
            }
        }
        updateSet(myOdds);
    }

    private static synchronized void updateSet(Set <Integer> e){
     s.addAll(e);
    }

    public static Set<Integer> findOdds(int [] a) {
        array=a;

        Odd[] threads=new Odd[numOfThreads];
        int k=Odd.array.length/numOfThreads;
        int i;
        for( i=0 ;i<numOfThreads-1 ; i++){
            threads[i]=new Odd(k*i,k*(i+1));
            threads[i].start();
        }
        threads[i]=new Odd(i*k,array.length);
        threads[i].start();


        try {
            for (int j = 0; j <numOfThreads ; j++) {
                threads[j].join();
            }
        }catch (InterruptedException e){
            System.out.println("some error");
        }
         return  s;
    }
    public static void main(String [] args){


        int [] array= {1,2,3,4,5,6,5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
     Set<Integer> s=findOdds(array);

        for (Object value : s) {
            System.out.println(value);
        }
    }


}
