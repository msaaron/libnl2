package libnl2;

import libnl2.coaster.Coaster;
import libnl2.info.Info;
import libnl2.io.Chunk;
import libnl2.io.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private Reader reader;
    private String filename;

    private Info info;
    private List<Coaster> coasters;

    public Park(String filename) throws IOException {
        this.filename = filename;
        this.reader = new Reader(this.filename);

        this.read();
    }

    private void read() throws IOException {
        this.reader.setPosition(0);

        // Check file signature
        String signature = this.reader.readChunkName();
        if (!signature.equals("NL2P")) {
            throw new IOException("Invalid NoLimits 2 Park File: " + this.filename);
        }

        // Skip null padding
        this.reader.skip(2);

        // Skip filesize info
        this.reader.skip(2);

        // Check file version for compatibility
        int major = this.reader.readUnsignedByte();
        int minor = this.reader.readUnsignedByte();
        int revision = this.reader.readUnsignedByte();
        int build = this.reader.readUnsignedByte();

        if (major != 2 || minor != 0 || revision != 5 || build != 2) {
            throw new IOException(String.format("Incompatible NoLimits 2 Park File. File version: %d.%d.%d.%d, supported: 2.0.5.2", major, minor, revision, build));
        }

        // Initialize Coasters List
        this.coasters = new ArrayList<>();

        // Read chunks
        while (!this.reader.reachedEOF()) {
            Chunk chunk = this.reader.readChunk();
            Reader chunkReader = new Reader(chunk.getData());

            switch (chunk.getName()) {
                case "INFO":
                    this.info = new Info(chunkReader);
                    break;

                case "USPK":
                    // System.out.println("USPK chunk: " + chunk.getData().length);
                    break;

                case "COAS":
                    Coaster coaster = new Coaster(chunkReader);
                    this.coasters.add(coaster);
                    break;
            }
        }
    }

    public Info getInfo() {
        return this.info;
    }

    public List<Coaster> getCoasters() {
        return this.coasters;
    }
}
