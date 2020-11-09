public class Dog extends Animal {

    public Dog(String name, String breed, int run, int swim, float jump) {
        super(name, breed, run, swim, jump);
    }

    @Override
    public void run() {
        if((this.breed).equals("GermanShepherd")){
            if (this.run <= 800){
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }
        else if((this.breed).equals("BullTerrier")){
            if (this.run <= 700){
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }
        else {
            if (this.run <= 500){ //Если другая порода
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }
    }

    @Override
    public void swim() {
        if((this.breed).equals("GermanShepherd")){
            if (this.swim <= 30){
                System.out.println(this.name + " может проплыть " + this.swim + " метров");
            }
            else {
                System.out.println(this.name + " не может проплыть " + this.swim + " метров");
            }
        }
        else if((this.breed).equals("BullTerrier")){
            if (this.swim <= 20){
                System.out.println(this.name + " может проплыть " + this.swim + " метров");
            }
            else {
                System.out.println(this.name + " не может проплыть " + this.swim + " метров");
            }
        }
        else { //Если другая порода
            if (this.swim <= 10){
                System.out.println(this.name + " может проплыть " + this.swim + " метров");
            }
            else {
                System.out.println(this.name + " не может проплыть " + this.swim + " метров");
            }
        }
    }

    @Override
    public void jump() {
        if((this.breed).equals("GermanShepherd")){
            if (this.jump <= 2.0F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
        else if((this.breed).equals("BullTerrier")){
            if (this.jump <= 1.5F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
        else { //Если другая порода
            if (this.jump <= 0.5F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
    }
}
