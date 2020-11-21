package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyArr implements Arr<String> {
    private ArrayList<String> MyArr = new ArrayList<>();

    public MyArr(ArrayList<String> myArr) {
        MyArr = myArr;
    }

    @Override
    public ArrayList<String> changeElement() {
        int a = 0;
        int b = this.MyArr.size()-1;
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex == secondIndex){
            firstIndex = a + (int)(Math.random()*((b - a) + 1));
            secondIndex = a + (int)(Math.random()*((b - a) + 1));
        }
        String c = this.MyArr.get(firstIndex);
        String d = this.MyArr.get(secondIndex);
        this.MyArr.set(firstIndex, d);
        this.MyArr.set(secondIndex, c);
        return MyArr;
    }

    @Override
    public ArrayList<String> iniArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные через пробел: ");
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            this.MyArr.add(arr[i]);
        }
        return MyArr;
    }

    @Override
    public String toString() {
        return "MyArr{" +
                "MyArr=" + MyArr +
                '}';
    }
}

