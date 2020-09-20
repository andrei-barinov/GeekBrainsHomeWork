import java.util.Arrays;

public class TheFivethAndSexthTasks {

    public static void main(String[] args) {

        int [] arr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int [] arr2 = {1, 1, 1, 1, 1};
        int [] arr3 = {3, 5, 7, 1, 2, 0, 11, 15};
        System.out.println(CheckArray(arr1));
        System.out.println(CheckArray(arr2));
        System.out.println(Arrays.toString(CiclicShift(arr3, 1)));
        System.out.println(Arrays.toString(CiclicShift(arr3, -2)));

    }

    public static boolean CheckArray(int [] arr){
        int a, b, i, c = 1;
        a = b = 0;
        boolean d = false;
        while (c != arr.length - 1){
            for(i = 0; i < c; i++) a += arr[i];
            for(i = c; i < arr.length; i++) b += arr[i];
            if(a == b){
                d = true;
                break;
            }
            c++;
            a = 0;
            b = 0;
        }
        return d;
    }

    public static int[] CiclicShift(int [] arr, int n){
        if (n >= 0){
            for(int i = 1; i <= n; i++ ){
                int tmp = arr[arr.length - 1];
                for(int j = arr.length-1; j > 0; j--){
                    arr[j] = arr[j-1];
                }
                arr[0] = tmp;
            }

        }
        else {
            n = (-1) * n;
            for(int i = 1; i <= n; i++){
                int tmp = arr[0];
                for(int j = 1; j < arr.length; j++){
                    arr[j - 1] = arr[j];
                }
                arr[arr.length-1] = tmp;
            }
        }
        return arr;
    }

}