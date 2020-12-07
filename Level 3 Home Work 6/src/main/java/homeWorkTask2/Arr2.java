package homeWorkTask2;

public final class Arr2 {
    private int[] arr;

    public Arr2(int[] arr) {
        this.arr = arr;
    }

    public static boolean checkArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1 || arr[i] == 4) return true;
        }
        return false;
    }
}
