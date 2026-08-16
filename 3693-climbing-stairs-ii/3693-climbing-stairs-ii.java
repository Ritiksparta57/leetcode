class Solution {
    public int climbStairs(int n, int[] costs) {
        //this is similar to min cost climbing stairs but with a different cost calcultion just;
        //i ma gonna make a dp for n+1 and the dp will be of 1-d state;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        //from the start that is 0 there are three possibility thus loop it over and check the minimum;
        return dfs(n,costs,dp);
    }
    public int dfs(int j,int[] costs,int[] dp){
        if(j==0)return 0;
        if(dp[j]!=-1)return dp[j];
        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        int three=Integer.MAX_VALUE;  
        if(j-1>=0){
        one=costs[j-1]+1+dfs(j-1,costs,dp);
        }
        if(j-2>=0){
        two=costs[j-1]+4+dfs(j-2,costs,dp);
        }
        if(j-3>=0){
        three=costs[j-1]+9+dfs(j-3,costs,dp);
        }
        return dp[j]=Math.min(one,Math.min(two,three));
    }
}