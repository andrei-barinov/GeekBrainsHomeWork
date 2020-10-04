public class SiameseCat extends Cat {
    private String name;
    private int run;
    private int swim;
    private float jump;

    public SiameseCat(String name, int run, int swim, int jump) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public SiameseCat(){

    }

    @Override
    public void run(){
        if (this.run <= 300){
            System.out.println(this.name + " может пробежать " + this.run + " метров");
        }
        else {
            System.out.println(this.name + " не может пробежать " + this.run + " метров");
        }
    }


    public void jump() {
        if (this.jump <= 1.5F){
            System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
        }
        else {
            System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
        }
    }
}
