package libnl2.info;

public class Weather {
    private boolean overrideDefaultWeather;
    private float rainIntensity;
    private float snowIntensity;
    private float fogIntensity;
    private float windIntensity;
    private float overcastIntensity;
    private float cloudsIntensity;
    private float thunderIntensity;

    public Weather() {

    }

    public boolean isOverrideDefaultWeather() {
        return this.overrideDefaultWeather;
    }

    public void setOverrideDefaultWeather(boolean overrideDefaultWeather) {
        this.overrideDefaultWeather = overrideDefaultWeather;
    }

    public float getRainIntensity() {
        return this.rainIntensity;
    }

    public void setRainIntensity(float rainIntensity) {
        this.rainIntensity = rainIntensity;
    }

    public float getSnowIntensity() {
        return this.snowIntensity;
    }

    public void setSnowIntensity(float snowIntensity) {
        this.snowIntensity = snowIntensity;
    }

    public float getFogIntensity() {
        return this.fogIntensity;
    }

    public void setFogIntensity(float fogIntensity) {
        this.fogIntensity = fogIntensity;
    }

    public float getWindIntensity() {
        return this.windIntensity;
    }

    public void setWindIntensity(float windIntensity) {
        this.windIntensity = windIntensity;
    }

    public float getOvercastIntensity() {
        return this.overcastIntensity;
    }

    public void setOvercastIntensity(float overcastIntensity) {
        this.overcastIntensity = overcastIntensity;
    }

    public float getCloudsIntensity() {
        return this.cloudsIntensity;
    }

    public void setCloudsIntensity(float cloudsIntensity) {
        this.cloudsIntensity = cloudsIntensity;
    }

    public float getThunderIntensity() {
        return this.thunderIntensity;
    }

    public void setThunderIntensity(float thunderIntensity) {
        this.thunderIntensity = thunderIntensity;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "overrideDefaultWeather=" + this.overrideDefaultWeather +
                ", rainIntensity=" + this.rainIntensity +
                ", snowIntensity=" + this.snowIntensity +
                ", fogIntensity=" + this.fogIntensity +
                ", windIntensity=" + this.windIntensity +
                ", overcastIntensity=" + this.overcastIntensity +
                ", cloudsIntensity=" + this.cloudsIntensity +
                ", thunderIntensity=" + this.thunderIntensity +
                '}';
    }
}
