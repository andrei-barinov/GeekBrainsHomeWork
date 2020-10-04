public class Cat extends Animal {
    protected String name;
    protected int run;
    protected int swim;
    protected float jump;

    public Cat(String name, int run, int swim, int jump) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public Cat(){

    }

    @Override
    public void run(){
        if (this.run <= 200){
            System.out.println(this.name + " может пробежать " + this.run + " метров");
        }
        else {
            System.out.println(this.name + " не может пробежать " + this.run + " метров");
        }
    }

    @Override
    public void swim() {
        System.out.println("Котики плавать не умеют(((");
    }

    public void jump() {
        if (this.jump <= 2F){
            System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
        }
        else {
            System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
        }
    }
}
