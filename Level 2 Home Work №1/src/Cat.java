public class Cat implements Action {
    private String name;
    private int CatLength;
    private int CatHeight;

    public Cat(String name, int catLength, int catHeight) {
        this.name = name;
        this.CatLength = catLength;
        this.CatHeight = catHeight;
    }

    @Override
    public void run(Track[] t) {
        boolean a = true;
        for(Track n: t){
            if (this.CatLength > n.getLength()) System.out.println("Кот " + this.name + " пробежал дистанцию " + n.getLength() + " м");
            else{
                System.out.println("Кот " + this.name + " не пробежал дистанцию " + n.getLength() + " м");
                a = false;
            }
            if (a == false) break;
        }
    }

    @Override
    public void jump(Wall[] w) {
        boolean a = true;
        for(Wall n: w){
            if (this.CatHeight > n.getHeight()) System.out.println("Кот " + this.name +  " перепрыгнул препятствие высотой " + n.getHeight() + " м");
            else{
                System.out.println("Кот " + this.name + " не перепрыгнул препятствие высотой " + n.getHeight() + " м");
                a = false;
            }
            if(a == false) break;
        }
    }
}
