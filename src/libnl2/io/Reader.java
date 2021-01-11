package libnl2.io;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * Implements a class used to read and parse the specified file into the appropriate data types.
 *
 * @author Matt Aaron
 * @version 1.0
 */
public class Reader {
    private final DataInputStream dataInputStream;
    private final InputStream inputStream;
    private FileChannel fileChannel;

    /**
     * Constructs a new Reader instance.
     * @param filename target *.nl2park file
     * @throws FileNotFoundException if the specified file does not exist
     */
    public Reader(String filename) throws FileNotFoundException {
        this.inputStream = new FileInputStream(filename);
        this.dataInputStream = new DataInputStream(this.inputStream);
        this.fileChannel = ((FileInputStream) this.inputStream).getChannel();
    }

    /**
     * Constructs a new Reader instance from chunk data.
     * @param data chunk data
     */
    public Reader(byte[] data) {
        this.inputStream = new ByteArrayInputStream(data);
        this.dataInputStream = new DataInputStream(this.inputStream);
    }

    public void setPosition(long newPosition) throws IOException {
        this.fileChannel.position(newPosition);
    }

    public void skip(long n) throws IOException {
        this.inputStream.skip(n);
    }

    public boolean reachedEOF() throws IOException {
        return this.inputStream.available() <= 0;
    }

    public int readUnsignedByte() throws IOException {
        return this.dataInputStream.readUnsignedByte();
    }

    public byte readByte() throws IOException {
        return this.dataInputStream.readByte();
    }

    public boolean readBoolean() throws IOException  {
        return this.dataInputStream.readBoolean();
    }

    public int readUnsignedShort() throws IOException {
        return this.dataInputStream.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return this.dataInputStream.readInt();
    }

    public float readFloat() throws IOException {
        return this.dataInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return this.dataInputStream.readDouble();
    }

    public Color readColor() throws IOException {
        return new Color(this.readUnsignedByte(), this.readUnsignedByte(), this.readUnsignedByte());
    }

    public Chunk readChunk() throws IOException {
        Chunk chunk = new Chunk(this.readChunkName());
        this.skip(2);
        int chunkSize = this.readUnsignedShort();
        chunk.setData(this.dataInputStream.readNBytes(chunkSize));

        return chunk;
    }

    public String readChunkName() throws IOException {
        byte[] chunkBytes = this.dataInputStream.readNBytes(4);

        return new String(chunkBytes, StandardCharsets.UTF_8);
    }

    public String readString() throws IOException {
        StringBuilder str = new StringBuilder();

        byte[] buffer = this.dataInputStream.readNBytes(2);
        while (buffer[1] != (byte) 0x00) {
            str.append((char) buffer[1]);
            buffer = this.dataInputStream.readNBytes(2);
        }

        return str.toString();
    }
}
