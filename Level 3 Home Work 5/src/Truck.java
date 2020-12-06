public class Truck implements Runnable {
    private String plate;
    private final float capacity = 60F;
    private float size = 60F;
    private float consumption = 1.5F;
    private FuelStation fuelStation;

    public Truck(String plate, FuelStation fuelStation) {
        this.plate = plate;
        this.fuelStation = fuelStation;
    }

    public void drive(){
        try {
            System.out.println(String.format("[%s] стартовал", plate));
            while (size > 3){
                Thread.sleep(500);
                size -= consumption;
                System.out.println(String.format("[%s] осталось топлива %s...", plate, size));
            }
            float refuel = fuelStation.refuel(capacity - size);
            if (refuel == 0){
                System.out.println(String.format("[%s] автомобиль остался без топлива", plate ));
                return;
            }
            System.out.println(String.format("[%s] Недостаточно топлива", plate, size));
            size += refuel;
            drive();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        drive();
    }
}
