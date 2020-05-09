public class DepthSreach {
    boolean[] ismarke;
    Integer[] paths;
    public DepthSreach(Graph g,int start){
        ismarke = new boolean[g.V()] ;
        paths = new Integer[g.V()] ;
        dfs(g,start);
    }

    public void dfs(Graph g,int start){
        ismarke[start] = true;
        for (Integer pr:g.args(start)) {
            if(!ismarke[pr]){ //如果没有被标记
                ismarke[pr] = true;
                paths[pr] = start;
                dfs(g,pr);
            }
        }
    }

    public boolean isConnect(int goal){
        return ismarke[goal];
    }

    public String getPath(int goal){
        if(paths[goal] == null) return  null;
        StringBuffer sb = new StringBuffer();
        for( ; goal !=  paths[goal] ; goal = paths[goal]){
            sb.append(goal).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Graph g =  new Graph(7);
        g.addPath(0,5);
        DepthSreach sreach = new DepthSreach(g,0);
        String path = sreach.getPath(5);
        System.out.println(path);
    }
}
