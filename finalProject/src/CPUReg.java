
import java.io.IOException;

//Register file  class has both read only and read write registers
public class CPUReg {


   private static  int numOfReadWriteReg=30;
   private  ReadOnlyReg r0;
   private ReadWriteReg [] array;

    public CPUReg() {
        r0=new ReadOnlyReg();
        array=new ReadWriteReg[numOfReadWriteReg];
       for (int i=0 ; i <numOfReadWriteReg ;i++){
          array[i]=new ReadWriteReg();
       }
    }


// function for reading registers
    public  int readReg(String regNumber) throws IOException{

        int regNo=Character.getNumericValue(regNumber.charAt(1));

        if(regNo>numOfReadWriteReg || !regNumber.startsWith("R")) {
            throw  new IOException("Not a valid address");
        }


        int val;
        if(regNo==0){ // get value of read only register r0
            try {
                val=r0.readReg();
                return val;
            } catch (IOException e) {
               throw e;

            }
        }else { // get value of all other registers

            try {
                val=array[regNo-1].readReg();
                return val;
            } catch (IOException e) {
                throw e;
            }

        }
    }

    // function for reading registers
    public  void writeReg(String regNumber, int val) throws  IOException{

        int regNo=Character.getNumericValue(regNumber.charAt(1));

        if(regNo>numOfReadWriteReg || !regNumber.startsWith("R")) {
            throw  new IOException("Not a valid address");
        }

        if(regNo==0){ // try to write to r0
            try {
                r0.writeReg(val);
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }else { // try to write to  all other registers
            try {
                array[regNo-1].writeReg(val);
            } catch (IOException e) {
                throw e;
            }

        }
    }
}
