public class Robot implements Participant{
    private String name;
    private int robLen;
    private int robHeight;

    public Robot(String name, int robLen, int robHeight) {
        this.name = name;
        this.robLen = robLen;
        this.robHeight = robHeight;
    }

    public String getName(){
        return name;

    }
    public int getHeight(){
        return robHeight;
    }

    public int getLen(){
        return robLen;
    }
}
