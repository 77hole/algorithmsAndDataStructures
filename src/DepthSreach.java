public class DepthSreach {
    boolean[] ismarke;
    Integer[] paths;
    int count; //分成几张图
    int start ;
    public DepthSreach(Graph g){
        ismarke = new boolean[g.V()] ;
        paths = new Integer[g.V()] ;
       // this.start = start;
        this.count = g.V();
        for(int i = 0 ; i< paths.length ; i++){
            paths[i] = i;
        }

        for(int i = 0 ;i< paths.length;i++){
            dfs(g,i);
        }
    }

    public void dfs(Graph g,int start){
    //    if(ismarke[start] == true)return;
        ismarke[start] = true;
        for (Integer pr:g.args(start)) {
            if(!ismarke[pr]){ //如果没有被标记
                ismarke[pr] = true;
                paths[pr] = start;
                dfs(g,pr);
                count --;
            }
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
        sb.append(goal);
        return sb.toString();
    }

    public static void main(String[] args){
        Graph g =  new Graph(10);
        g.addPath(0,1);
        g.addPath(1,2);
        g.addPath(2,3);
        g.addPath(3,4);
        g.addPath(4,5);
        g.addPath(5,6);
        g.addPath(6,7);
        g.addPath(7,8);
        g.addPath(8,9);
        g.addPath(9,0);
    //    g.addPath(0,9);
        DepthSreach sreach = new DepthSreach(g);
        String path = sreach.getPath(1);
        System.out.println(path);
        System.out.println(sreach.count);
    }
}
