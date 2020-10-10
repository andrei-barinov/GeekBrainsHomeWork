public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Vaska", 90),
                new Cat("Tomas", 30),
                new Cat("Begemot", 30),
        };

        Plate plate = new Plate(100);
        for(int i=0; i < cats.length; i++){
            plate.info();
            cats[i].eat(plate);
            cats[i].infoOfCatSatiety();
        }
        plate.info();
        plate.addFood(150);
        plate.info();
    }
}
