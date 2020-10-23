public class Main {

    public static void main(String[] args) {

        Action[] creatures = {
                new Human("human_1", 3000, 2),
                new Cat("cat_1", 200, 2),
                new Robot("robot_1", 10, 1),
        };

        Obstacles[] obstacles = {
                new Wall(1),
                new Track(10),
                new Wall(2),
                new Track(100),
                new Wall(3),
                new Track(1000)
        };

        for (Action creature : creatures) {
            creature.doAction(obstacles);

        }
    }
}
