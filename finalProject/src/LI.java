import java.io.IOException;

//class for load immediate instruction
class LI implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //write the immediate value to the register
            regFile.writeReg(args[1], Integer.parseInt(args[2]));

        } catch (IOException e) {
            throw e;
        }

    }
}