public class Track implements Obstacles {
    private int length;

    public Track(int length){
        this.length = length;
    }

    public int getParameter() {
        return length;
    }
}
