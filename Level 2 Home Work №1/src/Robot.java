public class Robot implements Action{
    private String name;
    private int RobotLength;
    private int RobotHeight;

    public Robot(String name, int robotLength, int robotHeight) {
        this.name = name;
        this.RobotLength = robotLength;
        this.RobotHeight = robotHeight;
    }

    @Override
    public void run(Track[] t) {
        boolean a = true;
        for(Track n: t){
            if (this.RobotLength > n.getLength()) System.out.println("Робот " + this.name + " пробежал дистанцию " + n.getLength() + " м");
            else{
                System.out.println("Робот "  + this.name + " не пробежал дистанцию " + n.getLength() + " м");
                a = false;
            }
            if (a == false) break;
        }
    }

    @Override
        public void jump(Wall[] w) {
        boolean a = true;
        for(Wall n: w){
            if (this.RobotHeight > n.getHeight()) System.out.println("Робот " + this.name + " перепрыгнул препятствие высотой " + n.getHeight() + " м");
            else{
                System.out.println("Робот " + this.name + " не перепрыгнул препятствие высотой " + n.getHeight() + " м");
                a = false;
            }
            if(a == false) break;
        }
    }
}
