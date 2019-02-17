import java.io.IOException;

//class for slt  instruction
class SLT implements Instruction {
    @Override
    public void execute(String[] args, CPUReg regFile)
            throws IOException {
        try {
            //set rd=1 if rs<rt shift
            if(regFile.readReg(args[2]) < regFile.readReg(args[3]))
            regFile.writeReg(args[1],1);//set 1
        }catch (IOException e){
            throw e;
        }

    }

}
