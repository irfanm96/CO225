import java.io.IOException;
//interface of a memory
public interface Memory {
     //has both read and write
     int read(int address) throws IOException;
     void write(int address, int val) throws IOException;
};