import java.io.IOException;
//interface for an instruction
interface Instruction {
    void execute(String [] args, CPUReg regFile) throws IOException;
}