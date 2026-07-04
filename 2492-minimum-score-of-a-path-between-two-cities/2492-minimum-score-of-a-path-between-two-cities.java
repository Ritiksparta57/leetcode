class Solution {
    public int par(int n,int[] par){
        if(n==par[n]){
            return n;
        }
        int ulp=par(par[n],par);
        par[n]=ulp;
        return par[n];
    }
    public void union(int a,int b,int[] par,int[] rank){
        int u=par(a,par);
        int v=par(b,par);
        if(u==v)return;
        if(rank[u]<rank[v])par[u]=v;
        else if(rank[v]<rank[u])par[v]=u;
        else{
            par[v]=u;
            rank[u]=rank[u]+1;
        }
    }
    public int minScore(int n, int[][] road) {
        int[] par=new int[n];
        int[] rank=new int[n];
        Arrays.fill(rank,1);
        for(int i=0;i<n;i++) par[i]=i;
        for(int i=0;i<road.length;i++){
            union(road[i][0]-1,road[i][1]-1,par,rank);
        }
        int parofone=par(0,par);
        int min=Integer.MAX_VALUE;
        for(int[] road1:road){
            int u=par(road1[0]-1,par);
            int v=par(road1[1]-1,par);
            int w=road1[2];
            if(u==parofone||v==parofone){
               min=Math.min(w,min);
            }
        }
        return min;
    }
}