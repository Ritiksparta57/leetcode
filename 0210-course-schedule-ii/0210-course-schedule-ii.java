class Solution {
    public int[] findOrder(int num, int[][] pre) {
       List<List<Integer>> l=new ArrayList<>();
       for(int i=0;i<num;i++){
        l.add(new ArrayList<>());
       }
       //let us build the dependency adjacency list;
       //for taking course x we need to go through y course thus x depends on y;
       //also coursetotake for x i.e. how many courses we need to take before joining that course;
       int[] coursetotake=new int[num];
       for(int i=0;i<pre.length;i++){
        int x=pre[i][0];
        int y=pre[i][1];
        coursetotake[x]++;
        l.get(y).add(x);
       }
       Queue<Integer> q=new LinkedList<>();
       List<Integer> ans=new ArrayList<>();
       for(int i=0;i<num;i++){
        if(coursetotake[i]==0){
            ans.add(i);
            q.offer(i);
        }
       }
       while(!q.isEmpty()){
            int y=q.poll();
            for(int neigh:l.get(y)){
                coursetotake[neigh]--;
                if(coursetotake[neigh]==0){
                    q.offer(neigh);
                    ans.add(neigh);
                }
            }
       }
       int[] res=new int[num];
       int i=0;
       for(int a:ans){
        res[i]=a;
        i++;
       }
       return ans.size()==num?res:new int[]{};
    }
}