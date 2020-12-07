import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 3, 3, 5, 6, 0, 7, 9, 0};
        System.out.println(checkArr(arr1));
    }

    public static boolean checkArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1 || arr[i] == 4) return true;
        }
        return false;
    }
}
