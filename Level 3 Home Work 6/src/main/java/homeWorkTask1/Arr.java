package homeWorkTask1;

public final class Arr {
    private int[] arr;

    public Arr(int[] arr) {
        this.arr = arr;
    }

    public static int[] changeArr(int [] Arr){
        int k = 0;
        int j = 0;
        for (int i = 0; i < Arr.length; i++){
            if(Arr[i] == 4){
                k = i;
                j++;
            }
        }
        if (j == 0){
            throw new RuntimeException("В массиве нет не одной четверки");
        }
        int b = Arr.length - k -1;
        int[] c = new int[b];
        for(int i = k + 1; i < Arr.length; i++){
            c[(i - 1 - k)] = Arr[i];
        }
        return c;
    }
}
