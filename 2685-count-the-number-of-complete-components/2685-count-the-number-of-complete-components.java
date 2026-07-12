class pair{
    int nodenum;
    int sumd;
    public pair(int n,int d){
        this.nodenum=n;
        this.sumd=d;
    }
}
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
        for(int i=0;i<n;i++){
            if(!visit[i]){
                int count=0;
                // we are counting degree as degree(in undirected)=no. of edges that are adjacent;
                //thus the sum of them gives the total degree sum and half of it will be the no. of edges;
                // as while counting the degree sum we add the total degree of every vertex(node) and thus while counting we add every edge two times as for every vertex the edge is going out and comin in from the same neighbouring vertex;
                int degreesum=0;
                pair p=dfs(l,visit,i,count,degreesum);
                // half of degreesum gives the no. of eges in that component;
                count=p.nodenum;
                degreesum=p.sumd;
                int edge=degreesum/2;
                int comp=(count*(count-1))/2;
                if(edge==comp)compco++;
            }
        }
        return compco;
    }
    public pair dfs(List<List<Integer>> l,boolean[] visit,int src,int node,int dsum){
        visit[src]=true;
        node++;
        // here we count how many edges are adjacent i.e. out and in from the vertex src and thus the size of it gives the degree of that vertex;
        dsum+=l.get(src).size();
        for(int neigh:l.get(src)){
            if(!visit[neigh]){
               pair p=dfs(l,visit,neigh,node,dsum);
               node=p.nodenum;
               dsum=p.sumd;
            }
        }
        return new pair(node,dsum);
    }
}