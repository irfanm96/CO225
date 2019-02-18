import java.io.IOException;

//register can be only read
class ReadOnlyReg extends RegBase {
    public ReadOnlyReg() { value = 0; }
    public int readReg() throws IOException { return 0; }
    public void writeReg(int value) throws IOException {
        throw new IOException("Can not write to a readonly reg");
    }

}



