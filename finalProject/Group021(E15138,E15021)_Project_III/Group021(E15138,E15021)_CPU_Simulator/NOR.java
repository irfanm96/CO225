import java.io.IOException;
//class for NOR instruction
class NOR implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform bitwise nor and write back to register
            regFile.writeReg(args[1], ~(regFile.readReg(args[2]) | regFile.readReg(args[3])));
        }catch (IOException e){
            throw e;
        }

    }
}
