package libnl2.io;

public class Chunk {
    private String name;
    private byte[] data;

    public Chunk(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
