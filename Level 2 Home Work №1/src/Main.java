public class Main
{
    public static void main(String[] args) {

        Participant[] participants = {
                new Human("human_1", 3000, 3),
                new Cat("cat_1", 200, 2),
                new Robot("robot_1", 10, 1),
                new Cat("cat_2", 300, 3),
                new Robot("robot_2", 2000, 4),
                new Human("human_2", 5000, 4)
        };

        Obstacles[] obstacles = {
                new Wall(1),
                new Track(1000),
                new Wall(2),
                new Track(2000),
                new Wall(3),
                new Track(2900),
                new Wall(1),
                new Wall(1),
        };

        for (Participant participant: participants){
            for(Obstacles ob: obstacles){
                ob.pass(participant);
                if(ob.breakCicle(participant)){
                    break;
                }
            }
            System.out.println();
        }


    }
}
