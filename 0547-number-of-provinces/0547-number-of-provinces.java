class Solution {
    public int findCircleNum(int[][] isConnected) {
      //for easy connection check i am gonna make every edge possible list;
      //this can be solved using bfs/dfs too as it just involves traversal of one node and then going deep to the bottom;
      //but i will be trying to solve using dsu;
      //the real problem is the this graph is undirected so we will be adding the same edges twice;  
      //we will look into that problem some other day let us try this once with the edges itself;
      int n=isConnected.length;
      List<int[]> l=new ArrayList<>();
      int i=0;
      for(int[] connect:isConnected){
         for(int j=0;j<connect.length;j++){
            if(connect[j]==1){
                l.add(new int[]{i,j});
            }
         }
         i++;
      }
      //since our edge list is made but this also contains duplicate still let us try union find;
      int[] par=new int[n];
      int[] rank=new int[n];
      for(int k=0;k<n;k++)par[k]=k;
      Arrays.fill(rank,0);
      for(int[] edge:l){
         int u=edge[0];
         int v=edge[1];
         int ulpu=findp(u,par);
         int ulpv=findp(v,par);
         if(ulpu==ulpv)continue;
         else{
            union(u,v,ulpu,ulpv,par,rank);
         }
      }
      //now let us count the no. of connected components;
      //we may use set for the different parent value storage;
      //in the intial approach i made one thing wrong ;
      //in par: 0,0,1,3 the node 2 has par=1 but ar node 1 the par=0 so both are connected thus instead of counting just the parent we count the par of a;
      //as a is already parent of node n so par[a] gives the parent of a thus making sure we take only the ultimate parent; 
      Set<Integer> st=new HashSet<>();
      for(int a:par)st.add(par[a]);
      return st.size();
    }
    public int findp(int u,int[] par){
        if(par[u]==u)return u;
        return par[u]=findp(par[u],par);
    }
    public void union(int u,int v,int ulpu,int ulpv,int[] par,int[] rank){
        if(rank[ulpu]<rank[ulpv])par[ulpu]=ulpv;
        else if(rank[ulpu]>rank[ulpv])par[ulpv]=ulpu;
        else{
            par[ulpv]=ulpu;
            rank[ulpu]++;
        }
    }
}