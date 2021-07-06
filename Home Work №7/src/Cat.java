public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if(appetite <= p.getFood()){
            p.decreaseFood(appetite);
            satiety = true;
        }
        else satiety = false;
    }

    public void infoOfCatSatiety(){
        System.out.println("satiety of " + this.name + ": " + satiety);
    }

}
