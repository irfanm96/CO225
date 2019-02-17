import java.io.IOException;

//class for instruction memory
public class ProgramMemory implements InstructionMemory {

    //variables
    private int sizeOfProgramMemory;//byte size
    private String[] memory;

    public ProgramMemory(int sizeInMB) {
        this.sizeOfProgramMemory = sizeInMB * 1024 * 1024;//size in bytes
        memory = new String[sizeOfProgramMemory];
    }


    //read instruction
    @Override
    public String read(int address) throws IOException {

        if (!withinMemory(address)) {
            throw new IOException("address not in the memory");
        } else {
            return memory[address];
        }

    }

    // add instruction to the memory ,this is used by the OS
    @Override
    public void addInstruction(int address, String instruction) throws IOException {
        if (address > sizeOfProgramMemory) {
            throw new IOException("Instruction Memory is full");
        } else {
            memory[address] = instruction;
        }

    }

//check the given address in instruction memory
    private boolean withinMemory(int address) {
        return (address >= 0) && (address < this.sizeOfProgramMemory);
    }

}
