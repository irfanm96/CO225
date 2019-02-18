public class ALU {

    private int operand1;
    private int operand2;
    private int opCode;


    public ALU(int operand1, int operand2, int opCode) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.opCode = opCode;
    }

    public int executeOperation(){
        switch (opCode){
            case 1: return  operand1+operand2;//add
            case 2: return   operand1-operand2;//sub
            case 3: return   operand1*operand2;//mul
            case 4: return   operand1/operand2;//div
            case 5 : return 0; //bitwise and
            case 6 : return 0;//bitwise or
            case 7 : return 0;//bitwise nor
            case 8 : return 0;//bitwise xor
            case 9 : return 0;// shift right
            case 10: return 0;//shift left
            case 11: return 0;//
        }
        return 0;
    }
}
