public class Animal {

    protected String name;
    protected String breed;
    protected int run;
    protected int swim;
    protected float jump;

    public Animal(String name, String breed, int run, int swim, float jump) {
        this.name = name;
        this.breed = breed;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public void jump(){};

    public void run(){};

    public void swim(){};
}
