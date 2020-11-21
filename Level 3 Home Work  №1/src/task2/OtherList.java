package task2;

import java.util.ArrayList;
import java.util.Arrays;

public class OtherList implements ArrayToList<Integer> {
    private Integer[] arr = new Integer[10];

    public OtherList(Integer[] arr) {
        this.arr = arr;
    }

    @Override
    public ArrayList<Integer> convertArr() {
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i =0; i < this.arr.length; i++){
            newArr.add(arr[i]);
        }
        return newArr;
    }

    @Override
    public String toString() {
        return "OtherList{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
