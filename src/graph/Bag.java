package graph;

import java.util.ArrayList;
import java.util.List;

public class Bag<T> {
    Node frist;
    class Node{
        public Node(T value){
            this.value = value;
        }
        T value;
        Node next;
    }
    public void add(T value){
        Node next = frist;
        frist = new Node(value);
        frist.next = next;
    }

    public List<T> values(){
        List<T> list = new ArrayList<>();
        values(frist,list);
        return list;
    }

    public void values(Node node,List<T> list){
        if (node == null) return;
        list.add(node.value);
        values(node.next,list);
    }

    public static void main(String[] args){
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        System.out.println(bag.values());
    }
}
