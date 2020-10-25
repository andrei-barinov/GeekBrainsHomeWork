public class Cat implements Participant{
    private String name;
    private int catLen;
    private int catHeight;

    public Cat(String name, int catLen, int catHeight) {
        this.name = name;
        this.catLen = catLen;
        this.catHeight = catHeight;
    }

    public String getName(){
        return name;
    }

    public int getHeight(){
        return catHeight;
    }

    public int getLen(){
        return catLen;
    }
}