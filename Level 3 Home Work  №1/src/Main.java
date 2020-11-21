import java.util.ArrayList;
import java.util.List;


import task1.MyArr;
import task2.OtherList;
import task3.Box;
import task3.Orange;
import task3.Apple;

public class Main {

    public static void main(String[] args) {

        /**
         * Задача №1
         * */


        ArrayList<String> arr = new ArrayList<>();
        MyArr MyArr = new MyArr(arr);
        MyArr.iniArr();
        MyArr.changeElement();
        System.out.println(MyArr);

        /**
        * Задача №2
        * */


        Integer[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        OtherList list = new OtherList(b);
        list.convertArr();
        System.out.println(list);


        /**
         * Задача №3
         * */

        Orange[] arr1 = {
                new Orange(1),
                new Orange(3),
                new Orange(5),
                new Orange(7),
                new Orange(2),
        };

        Apple[] arr2 = {
                new Apple(2),
                new Apple(3),
                new Apple(4),
                new Apple(5),
                new Apple(7),
        };

        Box<Orange> box1 = new Box<>();
        box1.addInBox(arr1);

        Box<Apple> box2 = new Box<Apple>();
        box2.addInBox(arr2);

        System.out.println("Weigth of box with orange: " + box1.getWeight());
        System.out.println("Weigth of box with apple: " + box2.getWeight());

        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<>();
        box1.changeBox(box3);

        Box<Orange> box5 = new Box<>();
        box5.addInBox(arr1);
        box3.changeBox(box5);
        System.out.println(box5);
        System.out.println(box3);

    }
}

