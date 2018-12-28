class Main {
//    public static int[][] a = { {3, -2, 5}, {3, 0, 4} };

//    public static int[][] b = { {2, 3}, {-9, 0}, {0, 4} };

    public static int [][] a= {{45, 8, 7, 4},
            {-7, 0, 6, 1},
            {3, 56, 7, 8},
            {95, 6, 1, 2},
            {4, 56, 1, -5}};

    public static int [][] b ={{1, 5, 7, 6, 7},
            {8, 6, 5, 3, 5},
            {6, 6, 1, 2, 5},
            {5, 1, 5, 9, 0}};
    private  static int numberOfThreads=5; // note that the number of threads cannot be zero or less than zero and you can change the number of threads
    // method to print matrix
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
            return;// return if cannot multiply
        }
        Matrix.setMatrices(a,b); //set up the matrices
        if(numberOfThreads>a.length){
            numberOfThreads=a.length;
            System.out.println("too much of threads ,only "+numberOfThreads+" threads are enough");
        }

       int k=a.length/numberOfThreads;// parts for the
        Matrix [] t=new Matrix[numberOfThreads];
        int i=0;
        for (i=0;i <numberOfThreads-1 ; i++) {
        t[i]= new Matrix(k*i,k*(i+1));
        t[i].start();
        }
        t[i]=new Matrix(i*k,a.length);
        t[i].start();

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
