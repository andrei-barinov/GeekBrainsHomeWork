import java.util.concurrent.Semaphore;

public class FuelStation {
    private GasPool gasPool;
    private Semaphore semaphore;

    public FuelStation() {
        this.gasPool = new GasPool();
        this.semaphore = new Semaphore(3);
    }

    public float refuel(float amount){
        try {
            semaphore.acquire();
            Thread.sleep(500);
            float request = gasPool.request(amount);
            System.out.println(gasPool);
            return request;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return 0F;
    }
}
