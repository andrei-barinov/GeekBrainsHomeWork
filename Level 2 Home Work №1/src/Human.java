
public class Human implements Participant{
    private String name;
    private int humanLen;
    private int humanHeight;

    public Human(String name, int humanLen, int humanHeight) {
        this.name = name;
        this.humanLen = humanLen;
        this.humanHeight = humanHeight;
    }

    public String getName(){
        return name;
    }

    public int getHeight(){
        return humanHeight;
    }

    public int getLen(){
        return humanLen;
    }
}


