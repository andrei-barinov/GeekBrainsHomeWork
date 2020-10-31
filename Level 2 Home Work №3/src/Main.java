import java.util.ArrayList;
import java.util.*;

public class Main
{
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Ананс");
        list.add("Яблоко");
        list.add("Банан");
        list.add("Апельсин");
        list.add("Авокадо");
        list.add("Виноград");
        list.add("Ананс");
        list.add("Малина");
        list.add("Клубника");
        list.add("Клубника");

        Collections.sort(list);

        System.out.println(list);

        System.out.println();

        TreeSet<String> h = new TreeSet<>();
        for(int i = 0; i < list.size(); i++){
            h.add(list.get(i));
        }

        System.out.println(h);

        System.out.println();

        for(String n: h){
            int counter = 0;
            for(int i = 0; i < list.size(); i++){
                if(n.equals(list.get(i))){
                    counter += 1;
                }
            }
            System.out.println(n + " = " + counter);
        }

        System.out.println();

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        telephoneDirectory.add("Смирнов", "+79503746893");
        telephoneDirectory.add("Иванов", "+79603746893");
        telephoneDirectory.add("Смирнов", "+79503746503");
        telephoneDirectory.add("Антонов", "+79673246093");
        telephoneDirectory.add("Петров", "+79503746893");
        telephoneDirectory.add("Матросов", "+79405749893");
        telephoneDirectory.add("Семенов", "+791035466893");

        telephoneDirectory.get("Смирнов");
        System.out.println();
        telephoneDirectory.get("Иванов");
    }


}
