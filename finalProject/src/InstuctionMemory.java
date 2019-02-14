public class InstuctionMemory implements  Memory {

    private static int size=64;
    private int [] array;// put the instructions


    public InstuctionMemory() {
        this.array = new int[size];
    }

    
    @Override
    public int read(int address) {
        return  array[address];
    }

    @Override
    public void write(int address, int data) {
        array[address]=data;
    }
}
