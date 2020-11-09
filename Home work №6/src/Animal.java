public abstract class Animal {

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

    public abstract void jump();

    public  abstract void run();

    public abstract void swim();
}
