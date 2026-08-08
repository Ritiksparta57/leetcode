class Solution {
    public int maxSatisfaction(int[] sat) {
        int n=sat.length;
        Arrays.sort(sat);
        int[][] dp=new int[n][n+1];
       for(int i=0;i<n;i++) Arrays.fill(dp[i],-(int)1e9);
        return dfs(0,n,dp,sat,1,0);
    }
    public int dfs(int i,int n,int[][] dp,int[] sat,int ind,int score){
        if(i==n){
             if(score<0)return -(int)1e9;
             else return 0;
        }
        if(dp[i][ind]!=-(int)1e9)return dp[i][ind];
        int sc=sat[i]*ind;
        int notpick=dfs(i+1,n,dp,sat,ind,score);
        int pick=(sc)+dfs(i+1,n,dp,sat,ind+1,sc);
        return dp[i][ind]=Math.max(pick,notpick);
    }
}