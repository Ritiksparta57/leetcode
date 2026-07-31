class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] newint=new int[n+1][2];
        for(int i=0;i<n;i++)newint[i]=intervals[i];
        newint[n]=newInterval;
        Arrays.sort(newint,(a,b)->a[0]-b[0]);
        List<int[]> l=new ArrayList<>();
        int[] prev=newint[0];
        for(int i=1;i<=n;i++){
            int[] current=newint[i];
            if(current[0]>prev[1]){
                l.add(prev);
                prev=current;
            }
            else{
                prev[0]=Math.min(prev[0],current[0]);
                prev[1]=Math.max(prev[1],current[1]);
            }
        }
        l.add(prev);
        int[][] ans=new int[l.size()][2];
        int in=0;
        for(int[] p:l){
            ans[in]=p;
            in++;
        }
        return ans;
   }
}