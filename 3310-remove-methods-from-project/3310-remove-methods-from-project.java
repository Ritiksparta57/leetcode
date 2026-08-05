class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invoc) {
        int m=invoc.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++)l.add(new ArrayList<>());
        for(int[] edge:invoc){
            int u=edge[0];
            int v=edge[1];
            l.get(u).add(v);
        }
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        dfs(l,vis,k);
        //the condition says if there exists even a single edge or even single neigh of the unvisited node then the whole group becomes unsuspicious;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                for(int num:l.get(i)){
                    if(vis[num]==true){
                        //the node which is connected to unsuspicious node is found and thus whole group is now safe thus make everyone in the array false;
                        for(int j=0;j<n;j++){
                            vis[j]=false;
                        }
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==false){
            ans.add(i);
            }
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