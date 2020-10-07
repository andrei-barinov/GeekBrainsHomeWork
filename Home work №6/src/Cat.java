public class Cat extends Animal {

    public Cat(String name, String breed, int run, int swim, float jump) {
        super(name, breed, run, swim, jump);
    }

    @Override
    public void run(){
        if((this.breed).equals("BengalCat")){
            if (this.run <= 400){
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }
        else if((this.breed).equals("SiameseCat")){
            if (this.run <= 300){
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }
        else { //Если другая порода
            if (this.run <= 200){
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }
    }

    @Override
    public void swim() {
        System.out.println("Котики плавать не умеют(((");
    }

    public void jump() {
        if((this.breed).equals("BengalCat")){
            if (this.jump <= 2.1F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
        else if((this.breed).equals("SiameseCat")){
            if (this.jump <= 2.3F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
        else { //Если другая порода
            if (this.jump <= 2.0F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
    }
}
