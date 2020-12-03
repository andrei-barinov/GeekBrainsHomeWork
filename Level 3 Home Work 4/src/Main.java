import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ABC abc = new ABC();

	    Thread t1 = new Thread(abc::printA);
        Thread t2 = new Thread(abc::printB);
        Thread t3 = new Thread(abc::printC);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);

        executorService.shutdown();
    }
}
