class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invoc) {
        int m=invoc.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] edge:invoc){
            int u=edge[0];
            int v=edge[1];
            l.get(u).add(v);
        }
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        dfs(l,vis,k);
        //if any single element is not visited i.e. not part of the group and if any edged node is already visited then the group will be free of suspicion;
        for(int i=0;i<n;i++){
            if(vis[i]==false){//node unvisited
                for(int num:l.get(i)){
                  if(vis[num]){//node is visited
                     //thus a direct cconnection to an unsuspicious one frees all the group memebers;
                     for(int j=0;j<n;j++)vis[j]=false;
                  }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==false)ans.add(i);
        }
        return ans;
    }
    public void dfs(List<List<Integer>> l,boolean[] vis,int k){
        vis[k]=true;
        for(int neigh:l.get(k)){
            if(vis[neigh]==false){
                dfs(l,vis,neigh);
            }
        }
    }
}