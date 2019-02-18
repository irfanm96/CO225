import java.io.IOException;

//class for BEQ  instruction implementing JType interface also
public class BEQ implements Instruction,JTypeInstruction {

    @Override
    public void execute(String[] args, CPUReg regFile) throws IOException {
     throw new IOException("Need a cpu input for J type instructions");
    }

    //override executeBranch method in J Type instruction interface
    @Override
    public void executeBranch(String[] args, CPU cpu, CPUReg regFile ) throws IOException {

        try {
            if(regFile.readReg(args[1])==regFile.readReg(args[2])){
                cpu.setProgramCounter(Integer.parseInt(args[3]));
            }
        }catch (IOException e){
            throw e;
        }

    }
}
