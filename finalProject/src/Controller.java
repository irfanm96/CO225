

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
        cnt.put("LI", new LI());
        cnt.put("DIV", new DIV());
        cnt.put("AND", new AND());
        cnt.put("OR", new OR());
        cnt.put("XOR", new XOR());
        cnt.put("SRL", new SRL());
        cnt.put("SLL", new SLL());

        //J type instruction
        cnt.put("BEQ", new BEQ());
        cnt.put("BGT", new BGT());

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
            inst.executeBranch(args, cpu, regFile);
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