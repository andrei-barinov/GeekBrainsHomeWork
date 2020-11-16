package structure.list;

import structure.list.impl.SingleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");

        GBIterator iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println(list);
        System.out.println(list.size());
        //list.remove("TOYOTA");
        //System.out.println(list);
        //System.out.println(list.size());
        System.out.println(list.getIndex(0));

    }
}
