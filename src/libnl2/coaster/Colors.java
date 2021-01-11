package libnl2.coaster;

import java.awt.*;

public class Colors {
    private Color wireframeTrack;
    private Color rails;
    private Color crossTies;
    private Color mainSpine;
    private Color car;
    private Color seat;
    private Color harness;
    private Color bogie;
    private Color chassis;
    private Color supports;
    private Color tunnel;
    private Color handrails;
    private Color catwalks;
    private int spineColorScheme;

    public Colors() {

    }

    public Color getWireframeTrack() {
        return this.wireframeTrack;
    }

    public void setWireframeTrack(Color wireframeTrack) {
        this.wireframeTrack = wireframeTrack;
    }

    public Color getRails() {
        return this.rails;
    }

    public void setRails(Color rails) {
        this.rails = rails;
    }

    public Color getCrossTies() {
        return this.crossTies;
    }

    public void setCrossTies(Color crossTies) {
        this.crossTies = crossTies;
    }

    public Color getMainSpine() {
        return this.mainSpine;
    }

    public void setMainSpine(Color mainSpine) {
        this.mainSpine = mainSpine;
    }

    public Color getCar() {
        return this.car;
    }

    public void setCar(Color car) {
        this.car = car;
    }

    public Color getSeat() {
        return this.seat;
    }

    public void setSeat(Color seat) {
        this.seat = seat;
    }

    public Color getHarness() {
        return this.harness;
    }

    public void setHarness(Color harness) {
        this.harness = harness;
    }

    public Color getBogie() {
        return this.bogie;
    }

    public void setBogie(Color bogie) {
        this.bogie = bogie;
    }

    public Color getChassis() {
        return this.chassis;
    }

    public void setChassis(Color chassis) {
        this.chassis = chassis;
    }

    public Color getSupports() {
        return this.supports;
    }

    public void setSupports(Color supports) {
        this.supports = supports;
    }

    public Color getTunnel() {
        return this.tunnel;
    }

    public void setTunnel(Color tunnel) {
        this.tunnel = tunnel;
    }

    public Color getHandrails() {
        return this.handrails;
    }

    public void setHandrails(Color handrails) {
        this.handrails = handrails;
    }

    public Color getCatwalks() {
        return this.catwalks;
    }

    public void setCatwalks(Color catwalks) {
        this.catwalks = catwalks;
    }

    public int getSpineColorScheme() {
        return this.spineColorScheme;
    }

    public void setSpineColorScheme(int spineColorScheme) {
        this.spineColorScheme = spineColorScheme;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "wireframeTrack=" + this.wireframeTrack +
                ", rails=" + this.rails +
                ", crossTies=" + this.crossTies +
                ", mainSpine=" + this.mainSpine +
                ", car=" + this.car +
                ", seat=" + this.seat +
                ", harness=" + this.harness +
                ", bogie=" + this.bogie +
                ", chassis=" + this.chassis +
                ", supports=" + this.supports +
                ", tunnel=" + this.tunnel +
                ", handrails=" + this.handrails +
                ", catwalks=" + this.catwalks +
                ", spineColorScheme=" + this.spineColorScheme +
                '}';
    }
}
