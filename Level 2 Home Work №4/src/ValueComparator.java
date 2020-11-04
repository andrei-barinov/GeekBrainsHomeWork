import java.util.TreeMap;
import java.util.*;

class ValueComparator implements Comparator<String>{
    private TreeMap<String, Integer> base;

    public ValueComparator(TreeMap<String, Integer> base){

        this.base = base;
    }


    public int compare(String a, String b){
        if(base.get(a) > base.get(b)) return 1;
        else if(base.get(a) == base.get(b)){
            if(Integer.parseInt(a) > Integer.parseInt(b)) return 1;
            else return -1;
        }
        else return -1;
    }
}