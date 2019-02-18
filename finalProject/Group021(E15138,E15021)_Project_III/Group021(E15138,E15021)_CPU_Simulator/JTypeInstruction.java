import java.io.IOException;

//interface for j type instruction
public interface JTypeInstruction  {
    //do branch
    void executeBranch(String [] args, CPU cpu , CPUReg regFile) throws IOException;

}
