class Main {
    public static int[][] a = {{1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}};

    public static int[][] b = {{1},
            {1},
            {1},
            {1}};
    private  static int numberOfThreads=2;
    public static void print_matrix(int[][] a) {


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int z1 = a[0].length;
        int z2 = b.length;

        if(z1 != z2) {
            System.out.println("Can not multiply");
            return;
        }
        Matrix.setA(a);
        Matrix.setB(b);

        if(numberOfThreads>=a.length){
            numberOfThreads=a.length;
            System.out.println("too much of threads ,only "+numberOfThreads+" threads are enough");
        }


        Matrix [] t=new Matrix[numberOfThreads];
        int i;
        for (i=0; i <numberOfThreads-1 ; i++) {
        t[i]= new Matrix(i,a.length/(i+1));
        t[i].start();
        }
        t[i]=new Matrix(i,a.length);

        try { // wait for all threads to complete
            for (int j = 0; j <numberOfThreads ; j++) {
                t[j].join();
            }
        } catch (InterruptedException e) { // if a thread is interrupted exit
            System.out.println("Thread execution interrupted");
            return;
        }


        print_matrix(Matrix.c); // see if the multipication is correct

    }
}