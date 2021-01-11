package libnl2.info;

import libnl2.io.Reader;

import java.io.IOException;
import java.util.Vector;

public class Info {
    private Reader chunkReader;

    private Weather weather;
    private String author;
    private String description;
    private String preview;
    private String environment;
    private Sky sky;
    private Vector<Float> initialPosition;
    private Vector<Float> initialRotation;
    private int initialView;

    public Info(Reader chunkReader) throws IOException {
        this.chunkReader = chunkReader;

        this.weather = new Weather();
        this.sky = new Sky();
        this.initialPosition = new Vector<>(3);
        this.initialRotation = new Vector<>(2);

        this.read();
    }

    private void read() throws IOException  {
        // Skip version info for now
        this.chunkReader.skip(31);

        // Weather
        this.weather.setOverrideDefaultWeather(this.chunkReader.readBoolean());
        this.weather.setRainIntensity(this.chunkReader.readFloat());
        this.weather.setSnowIntensity(this.chunkReader.readFloat());
        this.weather.setFogIntensity(this.chunkReader.readFloat());
        this.weather.setWindIntensity(this.chunkReader.readFloat());
        this.weather.setOvercastIntensity(this.chunkReader.readFloat());
        this.weather.setCloudsIntensity(this.chunkReader.readFloat());
        this.weather.setThunderIntensity(this.chunkReader.readFloat());

        this.chunkReader.skip(6);

        // File metadata
        this.author = this.chunkReader.readString();
        this.description = this.chunkReader.readString();
        this.preview = this.chunkReader.readString();
        this.environment = this.chunkReader.readString();

        this.chunkReader.skip(10);

        // Sky
        this.sky.setOverrideDefaultDateTime(this.chunkReader.readBoolean());
        this.sky.setMonth(this.chunkReader.readInt());
        this.sky.setDay(this.chunkReader.readInt());
        this.sky.setHour(this.chunkReader.readInt());
        this.sky.setMinute(this.chunkReader.readInt());

        this.chunkReader.skip(1);

        // Initial position
        this.initialPosition.add(this.chunkReader.readFloat());
        this.initialPosition.add(this.chunkReader.readFloat());
        this.initialPosition.add(this.chunkReader.readFloat());

        // Initial rotation
        this.initialRotation.add(this.chunkReader.readFloat());
        this.initialRotation.add(this.chunkReader.readFloat());

        // Initial view
        this.initialView = this.chunkReader.readUnsignedByte();
    }

    public Weather getWeather() {
        return weather;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getPreview() {
        return preview;
    }

    public String getEnvironment() {
        return environment;
    }

    public Sky getSky() {
        return sky;
    }

    public Vector<Float> getInitialPosition() {
        return initialPosition;
    }

    public Vector<Float> getInitialRotation() {
        return initialRotation;
    }

    public int getInitialView() {
        return initialView;
    }

    @Override
    public String toString() {
        return "Info{" +
                ", weather=" + this.weather +
                ", author='" + this.author + '\'' +
                ", description='" + this.description + '\'' +
                ", preview='" + this.preview + '\'' +
                ", environment='" + this.environment + '\'' +
                ", sky=" + this.sky +
                ", initialPosition=" + this.initialPosition +
                ", initialRotation=" + this.initialRotation +
                ", initialView=" + this.initialView +
                '}';
    }
}
