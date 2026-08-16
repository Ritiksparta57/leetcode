class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        //question of dsu;
        int[] par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int[] rank=new int[n];
        Arrays.fill(rank,0);//the initial height of the tree;
        //for every edge given in graph we need to find the parent of every node in that edge and then find if there parents are same or not;
        //if yes then the connection is redundant if no then connect them using union;
        List<int[]> reduntant=new ArrayList<>();
        for(int[] edge:edges){
            int u=edge[0]-1;
            int v=edge[1]-1;
            int ulpu=findp(u,par);
            int ulpv=findp(v,par);
            if(ulpu==ulpv){
                reduntant.add(new int[]{u+1,v+1});
            }
            else{
                union(u,v,par,rank,ulpu,ulpv);
            }
        }
        return reduntant.get(reduntant.size()-1);
    }
    //here we write the function findparent;
    public int findp(int u,int[] par){
        if(par[u]==u)return u;
        //if the par[u] is not u then we need to find the  parent of par[u];
        return findp(par[u],par);
    }
    //now here we will union the parents;
    public void union(int u,int v,int[] par,int[] rank,int ulpu,int ulpv){
           //now it is time to union the parents of u and v;
           //we have the ulp of u and v;
           if(rank[ulpu]<rank[ulpv]){
            par[ulpu]=ulpv;
           }
           else if(rank[ulpu]>rank[ulpv]){
            par[ulpv]=ulpu;
           }
           else{
            //when both rank are same then the height of tree is increased of whoever becomes the ultimate parent;
            par[ulpv]=ulpu;
            rank[ulpu]=rank[ulpu]+1;
           }
    }
}