import javax.sound.midi.Track;

public class Human implements Action {
    private String name;
    private int HumanLength;
    private int HumanHeight;

    public Human(String name, int humanLength, int humanHeight) {
        this.name = name;
        HumanLength = humanLength;
        HumanHeight = humanHeight;
    }

    public int getHumanLength() {
        return HumanLength;
    }

    public int getHumanHeight() {
        return HumanHeight;
    }

    @Override
    public void run(int HumanLength, int TrackLength) {
        if (HumanLength > TrackLength) System.out.println("Человек " + this.name + " пробежал дистанцию " + TrackLength + " м");
        else System.out.println("Человек " + this.name + " не пробежал дистанцию " + TrackLength + " м");
    }

    @Override
    public void jump(int HumanHeight, int WallHeigth) {
        if (HumanHeight > WallHeigth) System.out.println("Человек " +  this.name + " перепрыгнул препятствие высотой " + WallHeigth + " м" );
        else System.out.println("Человек " + this.name + " не перепрыгнул препятствие высотой " + WallHeigth + " м");
    }

}
