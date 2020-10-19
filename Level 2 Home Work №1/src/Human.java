
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
    public void run(Track[] t) {
        boolean a = true;
        for(Track n: t){
            if (this.HumanLength > n.getLength()) System.out.println("Человек " + this.name + " пробежал дистанцию " + n.getLength() + " м");
            else{
                System.out.println("Человек " + this.name + " не пробежал дистанцию " + n.getLength() + " м");
                a = false;
            }
            if (a == false) break;
        }
    }

    @Override
    public void jump(Wall[] w) {
        boolean a = true;
        for(Wall n: w){
            if (this.HumanHeight > n.getHeight()) System.out.println("Человек " +  this.name + " перепрыгнул препятствие высотой " + n.getHeight() + " м" );
            else{
                System.out.println("Человек " + this.name + " не перепрыгнул препятствие высотой " + n.getHeight() + " м");
                a = false;
            }
            if (a == false) break;
        }
    }

}
