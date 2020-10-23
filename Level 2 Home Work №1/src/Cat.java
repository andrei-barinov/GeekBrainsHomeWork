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
    public void doAction(Obstacles[] w) {
        for(Obstacles n: w){
            if(n instanceof Wall){
                if (this.CatHeight > n.getParameter()) System.out.println("Кот " +  this.name + " перепрыгнул препятствие высотой " + n.getParameter() + " м" );
                else{
                    System.out.println("Кот " + this.name + " не перепрыгнул препятствие высотой " + n.getParameter() + " м");
                    break;
                }
            }
            else{
                if (this.CatLength > n.getParameter()) System.out.println("Кот " +  this.name + " пробежал дистанцию " + n.getParameter() + " м" );
                else{
                    System.out.println("Кот " + this.name + " не пробежал дистанцию " + n.getParameter() + " м");
                    break;
                }
            }
        }
    }
}
