public class Main {

    public static void main(String[] args) {

        Object[] creatures = {
                new Human("human_1", 3000, 1),
                new Cat("cat_1", 200, 2),
                new Robot("robot_1", 10, 1),
                new Human("human_2", 5000, 2),
                new Cat("cat_2", 300, 4),
                new Robot("robot_2", 15, 2)
        };

        Object[] obstacles = {
                new Track(1000),
                new Wall(2),
                new Track(3000),
                new Wall(4)
        };
        for(int i = 0; i < creatures.length; i++){
            for(int j = 0; j < obstacles.length; j++){
                if(obstacles[j] == Track.class){
                    }
                }
            }
        }
    }
}
