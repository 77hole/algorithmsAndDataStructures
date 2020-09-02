import java.util.List;

public class WidthSreach {
    boolean[] ismarke;
    Integer[] paths;
    int start ;
    public WidthSreach(Graph g,int start){
        ismarke = new boolean[g.V()] ;
        paths = new Integer[g.V()] ;
        this.start = start;
        for(int i = 0 ; i< paths.length ; i++){
            paths[i] = i;
        }
        dfs(g,start);
    }

    public void dfs(Graph g,int start){
        ismarke[start] = true;
        Queue<Integer> queue = new Queue<>();
        queue.add(start);
        while (queue.size() > 0){
            int st = queue.get();
            for(Integer i : g.args(queue.get())){
                if(!ismarke[i]){
                    queue.add(i);
                    ismarke[i] = true;
                    paths[i] = st;
                }
            }
            queue.remove();
        }
    }

    public boolean isConnect(int goal){
        return ismarke[goal];
    }

    public String getPath(int goal){
        if(!isConnect(goal)) return  null;
        StringBuffer sb = new StringBuffer();
        for( ;paths[goal]  == null || goal !=  paths[goal] ; goal = paths[goal]){
            sb.append(goal).append("-");
        }
        sb.append(start);
        return sb.toString();
    }

    public static void main(String[] args){
        Graph g =  new Graph(7);
        g.addPath(0,5);
        g.addPath(5,3);
        g.addPath(3,1);
        g.addPath(0,4);
        WidthSreach sreach = new WidthSreach(g,0);
        String path = sreach.getPath(4);
        System.out.println(path);
    }
}
