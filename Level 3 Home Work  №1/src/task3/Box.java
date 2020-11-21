package task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    public  Box(){
    }

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    public ArrayList<T> addInBox(T[] list){
        for(int i = 0; i < list.length; i++){
            this.box.add(list[i]);
        }
        return box;
    }

    public int getWeight(){
        int weight = 0;
        for(int i =0; i < this.box.size(); i++){
            weight += this.box.get(i).getWeight();
        }
        return weight;
    }

    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }

    public void add(T fruit){
        box.add(fruit);
    }

    public Box<T> changeBox(Box<T> otherBox){
        ArrayList<T> list = new ArrayList<>();
        for(int i =0; i < this.box.size(); i++){
            otherBox.add(this.box.get(i));
        }

        while (this.box.size() != 0){
            int a = this.box.size()-1;
            this.box.remove(a);
        }
        return otherBox;
    }

    @Override
    public String toString() {
        return box.toString();
    }
}
