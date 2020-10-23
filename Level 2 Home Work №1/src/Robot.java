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
    public void doAction(Obstacles[] w) {
        for(Obstacles n: w){
            if(n instanceof Wall){
                if (this.RobotHeight > n.getParameter()) System.out.println("Робот " +  this.name + " перепрыгнул препятствие высотой " + n.getParameter() + " м" );
                else{
                    System.out.println("Робот " + this.name + " не перепрыгнул препятствие высотой " + n.getParameter() + " м");
                    break;
                }
            }
            else{
                if (this.RobotLength > n.getParameter()) System.out.println("Робот " +  this.name + " пробежал дистанцию " + n.getParameter() + " м" );
                else{
                    System.out.println("Робот " + this.name + " не пробежал дистанцию " + n.getParameter() + " м");
                    break;
                }
            }
        }
    }
}
