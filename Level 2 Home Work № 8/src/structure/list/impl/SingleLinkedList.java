package structure.list.impl;

import structure.list.GBIterator;
import structure.list.GBList;

public class SingleLinkedList implements GBList{
    private Node first;
    private int size = 0;

    public String getIndex(int index){
        int k = 0;
        Node current = first;
        while(true){
            if(current == null){
                return null;
            }
            else if(k == index){
                return current.val;
            }
            current = current.next;
            k++;
        }
    }

    public void add(String val){
        if (first == null){
            first = new Node(val);
        } else{
            add(first, val);
        }

        size++;
    }

    private void add(Node current, String val){
        if (current.next == null){
            current.next = new Node(val);
            current.next.prev = current;
            return;
        }
        add(current.next, val);
    }

    public boolean remove(String val){
        if(first.val.equals(val)){
            first = first.next;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null){
            if(current.val.equals(val)){
                prev.setNext(current.next);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    public int size(){
        return size;
    }

    public String toString(){
        return "SingleLinkedList{" + "first=" + first + '}';
    }

    public GBIterator iterator(){
        return new StraightForwardIterator(first);
    }

    private static class Node{
        private String val;
        private Node next;
        private Node prev;

        public Node(String val){
            this.val = val;
            this.next = null;
        }

        public String toString(){
            if(prev == null){
                return "Node{" + "val=" + val + '\'' + ", next=" + next + '}';
            } else return "Node{" + "prev=" + prev.val + '\'' + ", val=" + val + '\'' + ", next=" + next + '}';
        }

        public Node(Node prev, String val, Node next){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node next){
            this.next = next;
        }


    }

    public static class StraightForwardIterator implements GBIterator{
        private Node current;

        public StraightForwardIterator(Node current){
            this.current = current;
        }

        public boolean hasNext(){
            return current != null;
        }

        public String next(){
            String val = current.val;
            current = current.next;
            return val;
        }


    }
}
