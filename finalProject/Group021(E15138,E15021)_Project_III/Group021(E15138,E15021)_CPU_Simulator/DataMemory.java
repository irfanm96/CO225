public class DataMemory implements  Memory {

    private  static int size=256;
    private  int [] array;


    public DataMemory() {
        this.array = new int[size];
    }

    @Override
    public void write(int address, int data) {

    }


    @Override
    public int read(int address) {
        return 0;
    }
}
