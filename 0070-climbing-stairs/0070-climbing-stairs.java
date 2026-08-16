class Solution {
    public int climbStairs(int n) {
        //see if we are standing on the top then we needt o calculate the no. of ways to reach bottom 0;
        //now we can either take 1 step or 2 step at a point;
        // using 1 d dp to store the no. of ways we can reach at any x index;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(n,dp);
    }
    public int dfs(int i,int[] dp){
        //the bc is when we reach 0 then we add 1 as we do not need to go any further and we have got a valid path;
        if(i==0)return dp[i]=1;
        //if i<0 then the path is not correct;therfore return 0 as the path is not valid so why add it;
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int one=0;
        int two=0;
        one+=dfs(i-1,dp);
        two+=dfs(i-2,dp);
        return dp[i]=one+two;
    }
}