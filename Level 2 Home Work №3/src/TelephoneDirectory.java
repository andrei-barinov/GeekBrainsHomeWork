import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TelephoneDirectory {
    private Map<String, Set<String>> telDir = new HashMap<>();



    public void add(String surname, String number){
        Set<String> tel = telDir.getOrDefault(surname, new HashSet<>());
        tel.add(number);
        telDir.put(surname, tel);
    }


    public Set<String> get(String surname){
        Set<String> set = telDir.get(surname);
        return set;
    }

    public void printBook(){
        for(Map.Entry n: telDir.entrySet()){
            System.out.println(n);
        }
    }
}
