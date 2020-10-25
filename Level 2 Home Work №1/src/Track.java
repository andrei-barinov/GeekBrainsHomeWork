public class Track implements Obstacles{
    private int len;

    public Track(int len){
        this.len = len;
    }

    public void pass(Participant p){
        if(p.getLen() > this.len) System.out.println(p.getName() + " пробежал дистанцию " + this.len + " м");
        else System.out.println(p.getName() + " не пробежал дистанцию " + this.len + " м");
    }

    public boolean breakCicle(Participant p){
        return p.getLen() <= this.len;
    }
}

