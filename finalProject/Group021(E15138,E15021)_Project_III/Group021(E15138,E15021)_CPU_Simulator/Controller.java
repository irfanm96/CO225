

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    Map<String, Instruction> cnt;

    public Controller() {
        cnt = new HashMap<String, Instruction>();
        //R type instructions
        cnt.put("ADD", new ADD());
        cnt.put("SUB", new SUB());
        cnt.put("MUL", new MUL());
        cnt.put("DIV", new DIV());

        cnt.put("LI", new LI());

        cnt.put("AND", new AND());
        cnt.put("OR", new OR());
        cnt.put("XOR", new XOR());
        cnt.put("NOR", new NOR());

        cnt.put("SRL", new SRL());
        cnt.put("SLL", new SLL());
        cnt.put("SLT", new SLT());

        cnt.put("ADDI", new ADDI());
        cnt.put("SUBI", new SUBI());

        //J type instruction
        cnt.put("BEQ", new BEQ());
        cnt.put("BGT", new BGT());
        cnt.put("J", new J());


        //I type instructions
        cnt.put("LW", new LW());
        cnt.put("SW", new SW());


    }

    //method for executing R type instruction
    public void executeInstruction(String[] args, CPUReg
            regFile)
            throws IOException {
        Instruction inst = cnt.get(args[0]);
        if (inst == null) throw new IOException("Cannot find instruction");

        try {
            inst.execute(args, regFile);
        } catch (IOException e) {
            throw e;
        }

    }

    //overloaded method for executing J type instruction

    public void executeInstruction(String[] args, CPU cpu, CPUReg regFile)
            throws IOException {
        JTypeInstruction inst = (JTypeInstruction) cnt.get(args[0]);
        if (inst == null) throw new IOException("Cannot find instruction");

        try {
            if(args[0].equalsIgnoreCase("jal")){
                // save the current address before linking
                regFile.writeReg("R31",cpu.getProgramCounter());
                //execute the instruction
                inst.executeBranch(args, cpu, regFile);
                //come back to the next address stored in target register
                cpu.setProgramCounter(regFile.readReg("R31")+1);
            }else {
                inst.executeBranch(args, cpu, regFile);
            }

        } catch (IOException e) {
            throw e;
        }

    }

    //overloaded method for executing I type instruction

    public void executeInstruction(String[] args, CPUReg regFile, RAM ram)
            throws IOException {
        ITypeInstruction inst = (ITypeInstruction) cnt.get(args[0]);
        if (inst == null) throw new IOException("Cannot find instruction");

        try {
            inst.executeMemoryAccess(args, regFile, ram);
        } catch (IOException e) {
            throw e;
        }

    }
}