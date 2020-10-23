
public class Human implements Action {
    private String name;
    private int HumanLength;
    private int HumanHeight;

    public Human(String name, int humanLength, int humanHeight) {
        this.name = name;
        this.HumanLength = humanLength;
        this.HumanHeight = humanHeight;
    }


    @Override
    public void doAction(Obstacles[] w) {
        for(Obstacles n: w){
            if(n instanceof Wall){
                if (this.HumanHeight > n.getParameter()) System.out.println("Человек " +  this.name + " перепрыгнул препятствие высотой " + n.getParameter() + " м" );
                else{
                    System.out.println("Человек " + this.name + " не перепрыгнул препятствие высотой " + n.getParameter() + " м");
                    break;
                }
            }
            else{
                if (this.HumanLength > n.getParameter()) System.out.println("Человек " +  this.name + " пробежал дистанцию " + n.getParameter() + " м" );
                else{
                    System.out.println("Человек " + this.name + " не пробежал дистанцию " + n.getParameter() + " м");
                    break;
                }
            }
        }
    }

}


