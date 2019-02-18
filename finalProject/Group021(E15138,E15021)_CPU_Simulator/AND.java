import java.io.IOException;

// Bitwise AND instruction
class AND implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform bitwise and operation and write back to register
            regFile.writeReg(args[1], regFile.readReg(args[2]) & regFile.readReg(args[3]));
        } catch (IOException e) {
            throw e;
        }

    }
}


