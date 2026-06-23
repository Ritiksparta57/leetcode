class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
         int u=edges[i][0];
         int v=edges[i][1];
            l.get(u).add(v);
        }
        return dfs(0,baseTime,l);                                    
    } 
    public long dfs(int i,int[] base,List<List<Integer>> l){
        if(l.get(i).isEmpty()){
            return (long)base[i];
        }
        long earl=Long.MAX_VALUE;
        long late=Long.MIN_VALUE;
        for(int neigh:l.get(i)){
            long fin=dfs(neigh,base,l);
            earl=(long)Math.min(fin,earl);
            late=(long)Math.max(fin,late);
        }
        long own=(late-earl)+base[i];
        return own+late;
    }
}