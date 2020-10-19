public class Cat implements Action {
    private String name;
    private int CatLength;
    private int CatHeight;

    public Cat(String name, int catLength, int catHeight) {
        this.name = name;
        CatLength = catLength;
        CatHeight = catHeight;
    }

    @Override
    public void run(int CatLength, int TrackLength) {
        if (CatLength > TrackLength) System.out.println("Кот " + this.name + " пробежал дистанцию " + TrackLength + " м");
        else System.out.println("Кот " + this.name + " не пробежал дистанцию " + TrackLength + " м");
    }

    @Override
    public void jump(int CatHeight, int WallHeigth) {
        if (CatHeight > WallHeigth) System.out.println("Кот " + this.name +  " перепрыгнул препятствие высотой " + WallHeigth + " м");
        else System.out.println("Кот " + this.name + " не перепрыгнул препятствие высотой " + WallHeigth + " м");
    }
}
