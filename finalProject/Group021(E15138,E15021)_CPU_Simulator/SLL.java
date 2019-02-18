import java.io.IOException;

//class for shift left instruction
class SLL implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //perform shift left and write back to register
            regFile.writeReg(args[1],regFile.readReg(args[2]) * CustomMathLibrary.twosPow(regFile.readReg(args[3])));
        }catch (IOException e){
            throw e;
        }

    }

}
