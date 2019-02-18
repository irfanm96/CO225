import java.io.IOException;
//class for add immediate instruction
public class ADDI implements Instruction {

    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform immediate addition and write back to register
            regFile.writeReg(args[1], regFile.readReg(args[2]) + Integer.parseInt(args[3]));
        } catch (IOException e) {
            throw e;
        }

    }

}
