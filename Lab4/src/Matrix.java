public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    public static int [][] c;
    private int start,end;

	public static void setMatrices(int [][]a ,int [][]b){
		Matrix.a = a;
		Matrix.b = b;
		int x = a.length;
		int y = b[0].length;
		Matrix.c = new int [x][y];
	}

	 /* You might need other variables as well */

    public Matrix(int start,int end ) { // need to change this, might need some information
    	this.start=start;
    	this.end=end;
    }

    public void run(){
    	Matrix.multiply(this.start,this.end);
	}

    public static  void multiply(int start,int end) {

//	int x = a.length;
	int y = b[0].length;
	int z1 = a[0].length;

	int i, j, k, s;

	for(i=start; i<end; i++)
	    for(j=0; j<y; j++) {
		for(s=0, k=0; k<z1; k++) 
		    s += a[i][k] * b[k][j];
			Matrix.c[i][j]=s;
		}
    }

}