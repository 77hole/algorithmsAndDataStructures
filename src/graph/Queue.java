package graph;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    Node frist;
    int count ;
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
        count ++;
    }

    public T get(){
        if(frist == null){return null;}
      return frist.value;
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

    public void remove(){
        frist = frist.next;
        count --;
    }

    public int size(){
        return count;
    }
}
