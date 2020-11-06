public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        calculateArray();
        calculateArray_2();
    }

    public static void calculateArray(){
        float[] arr = new float[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1F;
        }

        long a = System.currentTimeMillis();

        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void calculateArray_2(){
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1F;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        doCalculate(a1, a2);
        outArr(a1, a2, a, arr);

    }

        public synchronized static void doCalculate(float[] a1, float[] a2){
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < a1.length; i++){
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < a2.length; i++){
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t2.start();


    }

    public synchronized static void outArr(float[] a1, float[] a2, long a, float [] arr){
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }
}
