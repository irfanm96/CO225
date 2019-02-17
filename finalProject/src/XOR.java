import java.io.IOException;

//instruction for bitwise xor
class XOR implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform bitwise xor and write back to register
            regFile.writeReg(args[1], regFile.readReg(args[2]) ^ regFile.readReg(args[3]));
        } catch (IOException e) {
            throw e;
        }

    }
}
