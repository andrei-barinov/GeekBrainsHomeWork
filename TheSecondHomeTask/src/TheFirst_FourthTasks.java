import java.util.Arrays;

public class TheFirst_FourthTasks {

    public static void main(String[] args) {
	    int [] arr = {1, 0, 0, 1, 0, 1, 0, 0, 1, 1};
	    for (int i=0; i < arr.length; i++){
	        if (arr[i] == 1) arr[i] = 0;
	        else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();

	    int[] arr2 = new int[8];
	    int b = 0;
	    for(int i = 0; i < arr2.length; i++){
	        arr2[i] = b;
	        b = arr2[i] + 3;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println();

	    int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
	    for(int i = 0; i < arr3.length; i++){
            if (arr3[i] < 6) arr3[i] = arr3[i] * 2;
            }
        System.out.println(Arrays.toString(arr3));
        System.out.println();

	    int[][] table = new int[5][5];
	    for(int i = 0; i < 5; i++){
	        for(int j = 0; j < 5; j++){
	            if(i == j) table[i][j] = 1;
	            else table[i][j] = (int) (Math.random() * 100);
                System.out.print(" " + table[i][j]);
            }
            System.out.println();
        }

    }

}
