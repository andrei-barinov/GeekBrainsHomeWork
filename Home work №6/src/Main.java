public class Main {

    public static void main(String[] args) {
        Cat SiameseCat1 = new Cat("Васька", "SiameseCat", 200, 50, 1.1F);
        SiameseCat1.run();
        SiameseCat1.swim();
        SiameseCat1.jump();

        System.out.println();

        Cat BengalCat1 = new Cat("Мурзик", "BengalCat", 500, 23, 1.4F);
        BengalCat1.run();
        BengalCat1.swim();
        BengalCat1.jump();

        System.out.println();

        Dog GermanShepherd1 = new Dog("Шарик", "GermanShepherd", 568, 12, 2.3F);
        GermanShepherd1.run();
        GermanShepherd1.swim();
        GermanShepherd1.jump();

        System.out.println();

        Dog BullTerrier1 = new Dog("Бобик", "BullTerrier", 975, 9, 0.9F);
        BullTerrier1.run();
        BullTerrier1.swim();
        BullTerrier1.jump();

        System.out.println();

        Dog Dvornyaga1 = new Dog("Тузик", "Дворняга", 435, 23, 0.3F);
        Dvornyaga1.run();
        Dvornyaga1.swim();
        Dvornyaga1.jump();
    }
}
