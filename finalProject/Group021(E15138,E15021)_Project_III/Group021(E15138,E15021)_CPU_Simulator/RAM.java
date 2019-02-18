import java.io.IOException;

//class for RAM (only  data memory)

public class RAM implements Memory {

    //variables
    int sizeOfRAM;//in bytes
    private int[] memory;

    public RAM(int sizeInMB) {
        sizeOfRAM = sizeInMB * 1024 * 1024;//size in bytes
        memory = new int[sizeOfRAM];
    }

    //check the given address in memory
    private boolean withinMemory(int address){
        return (address > 0) && (address < this.sizeOfRAM);
    }


    //read the memory ,used for load word instruction
    @Override
    public int read(int address) throws IOException {
        if (!withinMemory(address)) throw new IOException();
        return memory[address];
    }

    //write to memory , used for store word instruction
    @Override
    public void write(int address, int val) throws IOException {
        if (!withinMemory(address)) throw new IOException();
        memory[address]= val;
    }
}