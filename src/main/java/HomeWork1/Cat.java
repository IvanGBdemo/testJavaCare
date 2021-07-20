package HomeWork1;

public class Cat implements CanCompetitor {
    private double runningSpeed;
    private double jumpHeight;

    public double getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(double runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public double toRun(Treadmill treadmill) {
        double timeToOvercome = treadmill.getLength() / runningSpeed;
        System.out.println("Я кот, я пробежал беговую дорожку длиной " + treadmill.getLength() + " м за " + timeToOvercome + " с");
        return timeToOvercome;
    }

    public double jump(Wall wall) {
        double jumpResult = jumpHeight / wall.getHeight();
        if (jumpResult >= 1) {
            System.out.println("Я кот, я перепрыгнул стену высотой " + wall.getHeight() + " м!");
        } else {
            System.out.println("Я кот, я не перепрыгнул стену высотой " + wall.getHeight() + " м!");
        }
        return jumpResult;
    }
}
