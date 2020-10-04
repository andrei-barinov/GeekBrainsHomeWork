public class Dog extends Animal {
    protected String name;
    protected int run;
    protected int swim;
    protected float jump;

    public Dog(String name, int run, int swim, float jump) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public Dog(){

    }

    @Override
    public void run() {
        if (this.run <= 500){
            System.out.println(this.name + " может пробежать " + this.run + " метров");
        }
        else {
            System.out.println(this.name + " не может пробежать " + this.run + " метров");
        }
    }

    @Override
    public void swim() {
        if (this.swim <= 10){
            System.out.println(this.name + " может проплыть " + this.swim + " метров");
        }
        else {
            System.out.println(this.name + " не может проплыть " + this.swim + " метров");
        }
    }

    @Override
    public void jump() {
        if (this.jump <= 0.5F){
            System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
        }
        else {
            System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
        }
    }
}
