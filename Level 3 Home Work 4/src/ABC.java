public class ABC {
    private String currentLetter = "A";
    public void printA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("A")) {
                        wait();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("A");
                    currentLetter = "B";
                    notifyAll();
                }
            } catch (Exception e){
                throw new RuntimeException("Что-то пошло не так");
            }
        }
    }

    public void printB() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("B")) {
                        wait();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("B");
                    currentLetter = "C";
                    notifyAll();
                }
            } catch (Exception e){
                throw new RuntimeException("Что-то пошло не так");
            }
        }
    }

    public void printC() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("C")) {
                        wait();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("C");
                    currentLetter = "A";
                    notifyAll();
                }
            } catch (Exception e){
                throw new RuntimeException("Что-то пошло не так");
            }
        }
    }
}
