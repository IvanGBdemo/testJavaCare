package HomeWork1;

public class Wall {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTimeToOvercomeWall(CanCompetitor competitor) {
        return competitor.jump(this);
    }
}
//