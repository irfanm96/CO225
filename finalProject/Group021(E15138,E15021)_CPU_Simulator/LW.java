import java.io.IOException;

//class for load word instruction implementing I type instruction interface also
class LW implements Instruction, ITypeInstruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        throw new IOException("Need a Ram for I type instructions");
    }

    //override the method for i type instruction and write to the value in the ram to register
    @Override
    public void executeMemoryAccess(String[] args, CPUReg regFile, RAM ram) throws IOException {
            regFile.writeReg(args[1],ram.read(regFile.readReg(args[2])  + Integer.parseInt(args[3])));
    }
}
