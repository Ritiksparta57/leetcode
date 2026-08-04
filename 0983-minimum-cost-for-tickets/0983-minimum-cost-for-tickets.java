class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[][] dp=new int[n][366];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(0,n-1,days,costs,dp,0);
    }
    public int dfs(int i,int n,int[] days,int[] cost,int[][] dp,int daypass){
        if(i>n)return 0;
        if(i==n){
            if(daypass>=days[i])return 0;
        }
        if(daypass>=366)return 0;
        if(dp[i][daypass]!=-1)return dp[i][daypass];
        if(daypass>=days[i])return dfs(i+1,n,days,cost,dp,daypass);
        int oneday=cost[0]+dfs(i+1,n,days,cost,dp,days[i]);
        int sevday=cost[1]+dfs(i+1,n,days,cost,dp,days[i]+6);
        int month=cost[2]+dfs(i+1,n,days,cost,dp,days[i]+29);
        return dp[i][daypass]=Math.min(oneday,Math.min(sevday,month));
    }
}