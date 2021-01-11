package libnl2.coaster;

import libnl2.io.Reader;

import java.io.IOException;
import java.util.Vector;

public class Coaster {
    private Reader chunkReader;

    private Colors colors;
    private Mode mode;
    private String name;
    private String description;
    private int styleType;
    private int wornType;
    private int railType;
    private boolean frozen;
    private boolean hideWireframe;

    public Coaster(Reader chunkReader) throws IOException {
        this.chunkReader = chunkReader;

        this.colors = new Colors();
        this.mode = new Mode();

        this.read();
    }

    private void read() throws IOException  {
        this.name = this.chunkReader.readString();

        this.colors.setWireframeTrack(this.chunkReader.readColor());

        this.mode.setSplinePosition(this.chunkReader.readUnsignedByte());
        Vector<Double> splinePositionOffset = new Vector<>();
        splinePositionOffset.add(this.chunkReader.readDouble());
        splinePositionOffset.add(this.chunkReader.readDouble());
        this.mode.setSplinePositionOffset(splinePositionOffset);

        this.description = this.chunkReader.readString();
        this.styleType = this.chunkReader.readInt();

        this.colors.setRails(this.chunkReader.readColor());
        this.colors.setCrossTies(this.chunkReader.readColor());
        this.colors.setMainSpine(this.chunkReader.readColor());
        this.colors.setCar(this.chunkReader.readColor());
        this.colors.setSeat(this.chunkReader.readColor());
        this.colors.setHarness(this.chunkReader.readColor());
        this.colors.setBogie(this.chunkReader.readColor());

        this.frozen = this.chunkReader.readBoolean();

        this.colors.setSpineColorScheme(this.chunkReader.readUnsignedByte());
        this.colors.setSupports(this.chunkReader.readColor());
        this.colors.setTunnel(this.chunkReader.readColor());

        this.wornType = this.chunkReader.readUnsignedByte();

        this.colors.setChassis(this.chunkReader.readColor());

        // skip operation mode
        this.chunkReader.skip(1);

        this.railType = this.chunkReader.readUnsignedByte();

        this.colors.setHandrails(this.chunkReader.readColor());
        this.colors.setCatwalks(this.chunkReader.readColor());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public boolean isHideWireframe() {
        return hideWireframe;
    }

    @Override
    public String toString() {
        return "Coaster{" +
                "chunkReader=" + chunkReader +
                ", colors=" + colors +
                ", mode=" + mode +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
