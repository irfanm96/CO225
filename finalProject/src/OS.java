import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// OS module which loads and tells the cpu to execute a given program

public class OS {

    private CPU cpu;
    static String[] prog = {
            "LI R1 10",
            "LI R2 20",
            "ADD R3 R1 R2",
            "MUL R3 R3 R3",
            "LI R10 10" ,//should say not a valid address
            "LI e10 10" ,//should say not a valid address
            "LI R0 10", //should say cannot write to r0
    };

    public OS() {
        this.cpu = new CPU();
    }


    //load instructions from a file
    public void loadInstructions(String filename){

//        try {
//            File f = new File(filename);
//            BufferedReader b = new BufferedReader(new FileReader(f));
//            String readLine = "";
//            int i=0;
//            while ((readLine = b.readLine()) != null) {
//                cpu.programMemory.addInstruction(i++,readLine);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 7; i++) {
            try {
                cpu.programMemory.addInstruction(i,prog[i]);
            }catch (IOException e){
                System.out.println(e);
            }
        }

    }

    //run the program from a point to point
    public void runProgram(int start, int end){
            cpu.executeProgram(start,end);
    }


    //test the OS
    public static void main(String [] args){
        OS myOS=new OS();
        myOS.loadInstructions("sdsd");
        myOS.runProgram(0,6);

    }


}
