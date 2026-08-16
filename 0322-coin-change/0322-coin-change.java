class Solution {
    public int coinChange(int[] coins, int amount) {
        //here we are actaully counting steps there fore after every dfs call we will add1;
        //but since the answer depends on the index as well as the target sum;
        //therefore we need 2-d dp;
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        int ans=dfs(0,n-1,amount,dp,coins);
        return ans==(int)1e9?-1:ans;
    }
    public int dfs(int i,int n,int amount,int[][] dp,int[] coins){
        //since i can choose a coin multiple times until the amount is greater or equal to it then let us do it;
        // the basecases are
        //1.when i==n;
        //2.when amount==0;
        if(amount==0)return 0;
        if(i==n){
            //since it is the last index;
            //also it can be used multiple times thus we will see whether it gets divided by coin[i] or not;
            //if yes then return the quotient else return the highest possible value;
            if(amount%coins[i]==0){
                int ans=amount/coins[i];
                return ans;
            }
            else return (int)1e9;
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        //two conditions either we are picking the coin or not picking it;
        int not=dfs(i+1,n,amount,dp,coins);
        int pick=(int)1e9;
        if(amount>=coins[i]){
            pick=1+dfs(i,n,amount-(coins[i]),dp,coins);
        }
        return dp[i][amount]=Math.min(pick,not);
    }
}
//in max cases always use top down not bottom up as i have used here;