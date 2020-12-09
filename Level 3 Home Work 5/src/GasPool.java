import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final float capacity = 200F;
    private float size = 200F;

    public float request(float amount){
        lock.writeLock().lock();
        try {
            Thread.sleep(500);
            if (amount > size){
                return 0F;
            }
            size -= amount;
            return amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return 0F;
    }

    @Override
    public String toString() {
        lock.writeLock().lock();
        try{
            return "GasPool{" +
                    "size = " + size +
                    '}';
        } finally {
            lock.writeLock().unlock();
        }
    }
}
