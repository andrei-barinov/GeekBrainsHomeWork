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
        list.add("HYNDAY");
        System.out.println(list);
        System.out.println(list.getIndex(3));
        list.remove("BMW");
        System.out.println(list.size());
    }
}
