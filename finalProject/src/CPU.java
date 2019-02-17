import java.io.IOException;

public class CPU {

    //separate components for the CPU
    public ProgramMemory programMemory;
    private CPUReg regFile;
    private Controller controller;
    private RAM ram;
    private int programCounter;

    public CPU() {
        this.programMemory = new ProgramMemory(50);
        this.regFile = new CPUReg();
        this.controller = new Controller();
        this.ram = new RAM(256);
    }

    //used for J type instruction
    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    // executing a program from program memory
    public void executeProgram(int start, int end) {

        try {
            // start reading the instruction according to the program counter
            for (programCounter = start; programCounter < end + 1; programCounter++) {
                String[] cmd = programMemory.read(programCounter).split(" ");

                if (isIType(cmd[0])) {
                    //  I type instructions
                    controller.executeInstruction(cmd, this.regFile, this.ram);

                } else if (isJType(cmd[0])) {
                    //J type instructions
                    if (cmd[0].startsWith("J")) {
                        controller.executeInstruction(cmd, this, this.regFile);
                    } else {
                        System.out.println("beq");
                        controller.executeInstruction(cmd, this, this.regFile);
                    }
                } else {
                    //R type instructions
                    controller.executeInstruction(cmd, regFile);
                }
            }
        } catch (IOException e) {
//            System.out.println(e);
//            e.printStackTrace();
        }


    }

    //used to check the J type instruction
    private boolean isJType(String command) {

        return command.equalsIgnoreCase("beq") ||
                command.equalsIgnoreCase("bgt") ||
                command.equalsIgnoreCase("j") ||
                command.equalsIgnoreCase("jal") ||
                command.equalsIgnoreCase("jar");
    }


    //used to check the I type instruction

    private boolean isIType(String command) {

        return command.equalsIgnoreCase("lw") ||
                command.equalsIgnoreCase("sw");
    }
}
