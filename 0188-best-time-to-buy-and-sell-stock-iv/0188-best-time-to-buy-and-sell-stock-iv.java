class Solution {
    public int maxProfit(int k, int[] prices) {
        //this is an extension of bttbss 3 where cap was given as 2 but here it is given as k;
        //similar structure and operations;
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return dfs(0,n,1,k,prices,dp);
    }
    public int dfs(int i,int n,int buy,int k,int[] price,int[][][] dp){
        //base case is gonna be same that is when k==0 and i==n;
        if(i==n)return 0;//indexes are over;
        if(k==0)return 0;//k is over;
        if(dp[i][buy][k]!=-1)return dp[i][buy][k];
        int profit=0;
        //again two option either allowed to buy or not;
        if(buy==1){
            int webuy=-price[i]+dfs(i+1,n,0,k,price,dp);
            int notbuy=0+dfs(i+1,n,1,k,price,dp);
            profit=Math.max(webuy,notbuy);
        }
        else{
            int sell=price[i]+dfs(i+1,n,1,k-1,price,dp);
            int notsell=0+dfs(i+1,n,0,k,price,dp);
            profit=Math.max(sell,notsell);
        }
        return dp[i][buy][k]=profit;
    }
}