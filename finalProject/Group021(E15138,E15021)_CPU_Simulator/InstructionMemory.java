import java.io.IOException;

//interface for the instruction memory
public interface InstructionMemory {

    //has read and adding instruction methods
    String read(int address) throws IOException;
    void addInstruction(int address ,String instruction) throws IOException;

}
