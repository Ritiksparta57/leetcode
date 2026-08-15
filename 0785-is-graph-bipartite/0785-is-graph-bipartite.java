class Solution {
    public boolean isBipartite(int[][] graph) {
        //here we need to color the nodes;
        //we will just color the parent with 0th color say 0 and its children with 1st say 1;
        //then if we reach a node which is already colored but the color with which the parent wants to color and the color which is there are not same  then immediately return false as now we have entered a cycle;
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
         if(color[i]!=-1)continue;
        q.offer(i);
        color[i]=0;
        while(!q.isEmpty()){
          int par=q.poll();
          int col=color[par];
          int give=1;
          if(col==1)give=0;
          for(int neigh:graph[par]){
              if(color[neigh]!=-1){
                if(color[neigh]!=give)return false;
                else continue;
              }
              else{
              color[neigh]=give;
              q.offer(neigh);
              }
          }
        }
        }
        return true;
    }
}