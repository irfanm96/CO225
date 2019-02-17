import java.io.IOException;

//class for unconditional jum instruction
public class J implements Instruction, JTypeInstruction {
    @Override
    public void execute(String[] args, CPUReg regFile) throws IOException {
        throw new IOException("Need a cpu input for J type instructions");
    }

    //override the branch method in JType interface
    @Override
    public void executeBranch(String[] args, CPU cpu, CPUReg regFile) throws IOException {
        cpu.setProgramCounter(Integer.parseInt(args[1]));
    }
}
