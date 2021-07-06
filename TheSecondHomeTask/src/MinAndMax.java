public class MinAndMax {

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 6, 23, -67, 22, 6, 98, 12, 45, 0, 34};
        int min = arr[0], max = arr[0], i;
        for(i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }
        System.out.println("min = " + min + "\n" + "max = " + max);
    }
}
