package HomeWork1;

public class Treadmill {
    private double length;

    public Treadmill(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTimeToOvercomeTreadmill(CanCompetitor competitor) {
        return competitor.toRun(this);
    }
}
