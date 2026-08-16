class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //see the thing is there are two starting points 0 and 1;
        //so we can keep track when we skip 0 and take 1 and vice versa but why to do so;
        //instead of making things complicated we must make 2 1-d dp with starting point as 0 and 1;
        int n=cost.length;
        int[] dp0=new int[n];
        int[] dp1=new int[n];
        Arrays.fill(dp0,-1);
        Arrays.fill(dp1,-1);
        int min=Math.min(dfs(0,n-1,cost,dp0),dfs(1,n-1,cost,dp1));
        return min;
    }
    public int dfs(int i,int n,int[] cost,int[] dp){
        //we are not counting no. of steps neither no. of ways instead counting the cost;
        // so once we reach the end we will add 0;
        //also if we do not reach then make the value so large that it won't fit;
        //but since we can go after n then no need for any other bc;
        if(i>n)return 0;
        if(dp[i]!=-1)return dp[i];
        //the cost will surely be taken
        int c=cost[i];
        //now from each step we can either jump 1 or 2 step thus now perform climbing stairs but in a different manner that returns the cost not the ways;
        int one=c+dfs(i+1,n,cost,dp);
        int two=c+dfs(i+2,n,cost,dp);
        return dp[i]=Math.min(one,two);
    }
}