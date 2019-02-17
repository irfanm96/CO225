import java.io.IOException;
//class for store word instruction ,implementing itype instruction interface also
class SW implements Instruction, ITypeInstruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        throw new IOException("Need a Ram for I type instructions");
    }

    //execute store word instruction
    @Override
    public void executeMemoryAccess(String[] args, CPUReg regFile, RAM ram) throws IOException {
            ram.write(regFile.readReg(args[2])  + Integer.parseInt(args[3]),regFile.readReg(args[1]));
    }
}
