class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++)l.add(new ArrayList<>());
        boolean[] visit=new boolean[n];
        Arrays.fill(visit,false);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            l.get(u).add(v);
            l.get(v).add(u);
        }
       int compco=0;
       boolean[][] edgevisit=new boolean[n][n];
       for(int i=0;i<n;i++)Arrays.fill(edgevisit[i],false);
        for(int i=0;i<n;i++){
            if(!visit[i]){
                int count=dfs(l,visit,i);
                int edge=dfse(l,i,i,edgevisit);
                int comp=(count*(count-1))/2;
                if(edge==comp)compco++;
            }
        }
        return compco;
    }
    public int dfs(List<List<Integer>> l,boolean[] visit,int src){
        visit[src]=true;
        int count=1;
        for(int neigh:l.get(src)){
            if(!visit[neigh])count+=dfs(l,visit,neigh);
        }
        return count;
    }
    public int dfse(List<List<Integer>> l,int src,int prev,boolean[][] visit){
           visit[prev][src]=true;
           visit[src][prev]=true;
           int count=0;
           for(int neigh:l.get(src)){
            if(!visit[src][neigh])count+=1+dfse(l,neigh,src,visit);
           }
           return count;
    }
}