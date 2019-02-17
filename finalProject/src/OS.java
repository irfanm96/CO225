import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// OS module which loads and tells the cpu to execute a given program

public class OS {

    private CPU cpu;

    private int start;
    private int end;

    static String[] prog = {

            //load immediate
            "LI R1 10",//r1=10
            "LI R2 20",//r2=20

            //basic arithmetic operations
            "ADD R3 R1 R2",//r3=r1+r2
            "MUL R3 R3 R3",//r3=r3*r3
            "SUB R5 R3 R2",// r5=r3-r2
            "DIV R4 R3 R1",//r4=r3/r1 (integer division)

            //add or sub immediate
            "SUBI R5 R4 10", // r5=r4-10
            "ADDI R5 R5 10 ",//r5=r5+10

            //logical instructions
            "SLL R7 R1 R6",  // r7=r1>>r6 (shift left by r6)
            "SRL R8 R7 R6", //r8=r7<<r6 (shift right by r6)
            "SLT R9 R7 R6", //r9=1 if (r7 < r6)
            "AND R1 R1 R2" ,//bitwise and r1=r1 & r2 ,same format for all other instructions like
            /*
            * bitwise or -> OR R1 R3 R2
            * bitwise xor -> XOR R1 R3 R2
            * bitwise nor -> NOR R1 R3 R2
            * */

            //branch instructions
            "BEQ R5 R4 10", //go to address 10 if r5==r4
            "BGT R5 R4 10", //go to address 10 if r5>r4

            //Jump instructions
            "J 10", //go to address 10
            "JAL R5 R4 10", //Link and jump to 10 (note r31 will store the link address to come back)
            "JR R5" //go to address in r5




    };

    public OS() {
        this.cpu = new CPU();
    }


    //load instructions from a file
    public void loadInstructions(String filename){

        try {
            //should specify a filename
            File f = new File(filename);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            //this can be derived from the header file
            int i=start=0;//starting address of the instruction memory location can be given by the file header as well
            while ((readLine = b.readLine()) != null) {
                cpu.programMemory.addInstruction(i++,readLine);
            }
            end=i;//can change this by the information in header

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //run the program from a point to point
    public void runProgram(){
            //can set the start and if needed if not default values will be applied
            cpu.executeProgram(start,end);
    }


    //test the OS
    public static void main(String [] args){
        OS myOS=new OS();

        myOS.loadInstructions("SHOULD GIVE THE PATH");//should give the file name to be loaded
        //can be loaded from the file header
        myOS.runProgram();//execute only the required part as OS

    }


}
