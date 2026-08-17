class Solution {
    public int change(int amount, int[] coins) {
        //well in coin change we were counting how many steps (minimum) would be taken to reach the amount;
        //but here we are talking about in how many ways we can reach leaving the no. of steps;
        //since the ans heavily relies on amount and index ->2-d dp;
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(n-1,dp,amount,coins);
    }
    public int dfs(int n,int[][] dp,int amount,int[] coins){
        //since we have to count the no. of ways not steps thus we will not add 1;
        //base condition is when we reach amount=0 and n=0;
        if(amount==0)return 1;//we have got 1 way to reach the amount;
        if(n==0){
            //the very last index;
            //so we need to check whether the last index can produce the desired amount;
            if(amount%coins[n]==0){
                return 1;//we need not to count in how many times we reach amount we just need to see whether we can reach or not;
            }
            else return 0;
        }
        if(dp[n][amount]!=-1)return dp[n][amount];
        //now we can surely pick or not pick the given coin;
        int not=0;
        int pick=0;
        //if we are adding 1 then it is fixed we have a way to reach amount even if we do not have;
        //therefore we use += so that if there is no way 0 is added and if there is a way 1 is added;
        not+=dfs(n-1,dp,amount,coins);
        if(amount>=coins[n]){
            //if the condition is true then only we can take otherwise it is impossible to take;
            pick+=dfs(n,dp,amount-coins[n],coins);
        }
        //here we are not finding any minimum or maximum steps we are finding the no. of ways thus total =not+pick;
        return dp[n][amount]=not+pick;
    }
}