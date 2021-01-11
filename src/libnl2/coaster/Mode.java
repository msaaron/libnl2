package libnl2.coaster;

import java.util.Vector;

public class Mode {
    private int splinePosition;
    private Vector<Double> splinePositionOffset;

    public Mode() {

    }

    public int getSplinePosition() {
        return this.splinePosition;
    }

    public void setSplinePosition(int splinePosition) {
        this.splinePosition = splinePosition;
    }

    public Vector<Double> getSplinePositionOffset() {
        return this.splinePositionOffset;
    }

    public void setSplinePositionOffset(Vector<Double> splinePositionOffset) {
        this.splinePositionOffset = splinePositionOffset;
    }
}
