import java.util.TreeMap;
import java.lang.*;


public class Main {

    public static void main(String[] args) {

        TreeMap<String, Integer> tree = new TreeMap<>();
        ValueComparator newTree = new ValueComparator(tree);
        TreeMap<String, Integer> sorted_tree = new TreeMap<String, Integer>(newTree);

        tree.put("1", 3);
        tree.put("2", 10);
        tree.put("3", 1);
        tree.put("4", 17);
        tree.put("5", 0);

        System.out.println(tree);
        sorted_tree.putAll(tree);
        System.out.println(sorted_tree);
    }
}