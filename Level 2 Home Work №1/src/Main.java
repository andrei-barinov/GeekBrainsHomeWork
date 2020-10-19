public class Main {

    public static void main(String[] args) {

        Action[] creatures = {
                new Human("human_1", 3000, 2),
                new Cat("cat_1", 200, 2),
                new Robot("robot_1", 10, 1),
        };

        Wall[] wall = {
                new Wall(1),
                new Wall(2),
                new Wall(3)
        };

        Track[] track = {
                new Track(10),
                new Track(100),
                new Track(10000)
        };

        for(Action creature: creatures){
            creature.run(track);
            creature.jump(wall);
            System.out.println();
        }

    }
}
