import java.io.IOException;
//class for bitwise or instruction
class OR implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform bitwise or operation and write back to the register
            regFile.writeReg(args[1],regFile.readReg(args[2]) | regFile.readReg(args[3]));
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
