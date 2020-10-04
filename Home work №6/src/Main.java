public class Main {

    public static void main(String[] args) {
        BullTerrier BullTerrier_1 = new BullTerrier("Дружок", 510, 9, 0.5f);
        BullTerrier_1.run();
        BullTerrier_1.swim();
        BullTerrier_1.jump();

        System.out.println();

        GermanShepherd GermanShepherd_1 = new GermanShepherd("Шарик", 730, 15, 1.25f);
        GermanShepherd_1.run();
        GermanShepherd_1.swim();
        GermanShepherd_1.jump();

        System.out.println();


        BengalCat BengalCat_1 = new BengalCat("Мурзик", 150, 3, 1);
        BengalCat_1.run();
        BengalCat_1.swim();
        BengalCat_1.jump();

        System.out.println();

        SiameseCat SiameseCat_1 = new SiameseCat("Багира", 600, 1, 3);
        SiameseCat_1.run();
        SiameseCat_1.swim();
        SiameseCat_1.jump();
    }
}
