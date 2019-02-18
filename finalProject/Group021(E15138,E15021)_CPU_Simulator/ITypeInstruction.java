import java.io.IOException;

//interface for execution of i type instruction
public interface ITypeInstruction {

    //do memory access
    void executeMemoryAccess(String[] args, CPUReg regFile, RAM ram) throws IOException;

}
