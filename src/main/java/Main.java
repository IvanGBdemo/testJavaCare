
public class Main {

    public static void main(String[] args) {

        //2.Участники должны бежать по беговой дорожке или прыгать через стену

        Cat catCompetitor1 = new Cat();
        catCompetitor1.setRunningSpeed(4);
        catCompetitor1.setJumpHeight(2);
        Human humanCompetitor1 = new Human();
        humanCompetitor1.setRunningSpeed(6);
        humanCompetitor1.setJumpHeight(3);
        Robot robotCompetitor1 = new Robot();
        robotCompetitor1.setRunningSpeed(9);
        robotCompetitor1.setJumpHeight(4);

       /*
       3. Создать наборы участников и препятствий, и заставьте всех участников пройти этот набор препятствий. (* Реализовать с помощью двух массивов)
       Предполагаю, что решение с помощью массивов должно выглядеть примерно так:

        Competitor[] competition = {cat, human, robot};

        for (int i = 0; i < competition.length; i++) {
            competition[i].getTimeToOvercomeTreadmill()
        }

        for (int i = 0; i < competition.length; i++) {
            competition[i].getTimeToOvercomeWall()
        }
        */

        Treadmill[] treadmills = {new Treadmill(15), new Treadmill(20), new Treadmill(35)};
        Wall[] walls = {new Wall(2), new Wall(4), new Wall(6)};

        for (Treadmill treadmill : treadmills) {
            treadmill.getTimeToOvercomeTreadmill(catCompetitor1);
            treadmill.getTimeToOvercomeTreadmill(humanCompetitor1);
            treadmill.getTimeToOvercomeTreadmill(robotCompetitor1);
        }

        for (Wall wall : walls) {
            wall.getTimeToOvercomeWall(catCompetitor1);
            wall.getTimeToOvercomeWall(humanCompetitor1);
            wall.getTimeToOvercomeWall(robotCompetitor1);
        }
    }
}
/* 5* Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
Для решения задачи необходимо в код ввести конструкцию for - break или while - break. К сожалению, не нашёл - как ввести конструкцию.
 */
