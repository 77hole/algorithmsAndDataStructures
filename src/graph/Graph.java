package graph;

import java.util.List;

/**
 * 无向图
 * */
public class Graph {
    private Bag<Integer>[] args;
    private Integer V;
    public Graph(int n){
        args = new Bag[n];
        V = n;
        for(int i=0 ; i<n ; i++){
            args[i] = new Bag<Integer>();
        }
    }

    public void addPath(int i,int j){
        Bag<Integer> iBag = args[i];
        iBag.add(j);
        Bag<Integer> jBag = args[j];
        jBag.add(i);
    }

    public List<Integer> args(int i){
        return args[i].values();
    }

    public int V(){return V;}
}
