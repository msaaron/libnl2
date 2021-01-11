package libnl2.info;

public class Sky {
    private boolean overrideDefaultDateTime;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public Sky() {

    }

    public boolean isOverrideDefaultDateTime() {
        return this.overrideDefaultDateTime;
    }

    public void setOverrideDefaultDateTime(boolean overrideDefaultDateTime) {
        this.overrideDefaultDateTime = overrideDefaultDateTime;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Sky{" +
                "overrideDefaultDateTime=" + this.overrideDefaultDateTime +
                ", month=" + this.month +
                ", day=" + this.day +
                ", hour=" + this.hour +
                ", minute=" + this.minute +
                '}';
    }
}
