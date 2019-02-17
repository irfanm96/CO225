import java.io.IOException;

public class JAL implements Instruction, JTypeInstruction {

    @Override
    public void execute(String[] args, CPUReg regFile) throws IOException {
        throw new IOException("Need a cpu input for J type instructions");
    }

    //override executeBranch method in J Type instruction interface
    @Override
    public void executeBranch(String[] args, CPU cpu, CPUReg regFile) throws IOException {
        //set program counter to the link address
        cpu.setProgramCounter(Integer.parseInt(args[3]));
    }


}
