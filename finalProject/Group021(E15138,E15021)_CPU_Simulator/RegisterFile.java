public class RegisterFile {

    private static int size=8;
    private int [] array;

    public RegisterFile() {
        this.array = new int[size];
    }

    public int [] readRegisters(int reg1, int reg2){
        int [] output=new int[2];
        output[0]=array[reg1];
        output[1]=array[reg2];
        return  output;
    }
    public void writeRegister(int reg, int data){
        array[reg]=data;
    }

}
