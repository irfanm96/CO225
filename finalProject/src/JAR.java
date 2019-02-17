import java.io.IOException;

//class for jump to address in target register instruction
public class JAR implements Instruction, JTypeInstruction {
    @Override
    public void execute(String[] args, CPUReg regFile) throws IOException {
        throw new IOException("Need a cpu input for J type instructions");
    }

    //override the branch method in JType interface
    @Override
    public void executeBranch(String[] args, CPU cpu, CPUReg regFile) throws IOException {
        cpu.setProgramCounter(regFile.readReg(args[1]));
    }
}
