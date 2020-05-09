import java.util.List;

public class Graph {
    private Bag<Integer>[] V;
    public Graph(int n){
        V = new Bag[n];
        for(int i=0 ; i<n ; i++){
            V[i] = new Bag<Integer>();
        }
    }

    public void addPath(int i,int j){
        Bag<Integer> iBag = V[i];
        iBag.add(j);
        Bag<Integer> jBag = V[j];
        iBag.add(i);
    }

    public List<Integer> args(int i){
        return V[i].values();
    }
}
