import java.io.IOException;

//register can be both read and written
class ReadWriteReg extends RegBase {
    public ReadWriteReg() { value = 0; }
    @Override
    public int readReg() throws IOException { return value; }
    @Override
    public void writeReg(int value) throws IOException {
        this.value = value;
    }
}
