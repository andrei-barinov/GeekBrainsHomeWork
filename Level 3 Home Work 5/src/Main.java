import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FuelStation fuelStation = new FuelStation();
        executorService.submit(new Car("Car - 1", fuelStation));
        executorService.submit(new Car("Car - 2", fuelStation));
        executorService.submit(new Car("Car - 3", fuelStation));
        executorService.submit(new Truck("Truck -1", fuelStation));
        executorService.submit(new Truck("Truck -2", fuelStation));
        executorService.submit(new Truck("Truck -3", fuelStation));
        executorService.submit(new Bus("Bus -1", fuelStation));
        executorService.submit(new Bus("Bus -2", fuelStation));
        executorService.submit(new Bus("Bus -3", fuelStation));
        executorService.submit(new Car("Car - 4", fuelStation));

        executorService.shutdown();

    }
}
