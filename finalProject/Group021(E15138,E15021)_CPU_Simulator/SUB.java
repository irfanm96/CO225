import java.io.IOException;

//class for subtraction instruction
class SUB implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform subtraction and write back to register
            regFile.writeReg(args[1],regFile.readReg(args[2]) - regFile.readReg(args[3]));
        } catch (IOException e) {
            throw e;
        }
    }
}