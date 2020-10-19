public class Robot implements Action{
    private String name;
    private int RobotLength;
    private int RobotHeight;

    public Robot(String name, int robotLength, int robotHeight) {
        this.name = name;
        RobotLength = robotLength;
        RobotHeight = robotHeight;
    }

    @Override
    public void run(int RobotLength, int TrackLength) {
        if (RobotLength > TrackLength) System.out.println("Робот " + this.name + " пробежал дистанцию " + TrackLength + " м");
        else System.out.println("Робот "  + this.name + " не пробежал дистанцию " + TrackLength + " м");
    }

    @Override
        public void jump(int RobotHeight, int WallHeigth) {
        if (RobotHeight > WallHeigth) System.out.println("Робот " + this.name + " перепрыгнул препятствие высотой " + WallHeigth + " м");
        else System.out.println("Робот " + this.name + " не перепрыгнул препятствие высотой " + WallHeigth + " м");
    }
}
