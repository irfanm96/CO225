import java.io.IOException;

//abstract class for register file
abstract class RegBase {
    protected int value;
    abstract public int readReg() throws IOException;
    abstract public void writeReg(int value) throws
            IOException;
}
