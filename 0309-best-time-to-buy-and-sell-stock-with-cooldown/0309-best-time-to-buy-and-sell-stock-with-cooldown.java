class Solution {
    public int maxProfit(int[] prices) {
        //this is of similar pattern of bttbss 2 but with a restriction on buying;
        //the day we sell then we are not goin to buy the other day;
        //there in no restriction on no. of transaction so infinite no. of transaction we can do;
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(0,n,1,dp,prices);
    }
    public int dfs(int i,int n,int buy,int[][] dp,int[] price){
        //now the base case is when the i goes beyond or equal to n;
        if(i>=n)return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        //now here are the two possibilities either i am allowed to buy or i am not allowed to buy;
        int profit=0;
        if(buy==1){
            //here are two possibilities either we buy or we do not buy;
            int webuy=-price[i]+dfs(i+1,n,0,dp,price);
            int notbuy=dfs(i+1,n,1,dp,price);
            profit=Math.max(webuy,notbuy);
        }
        else{
            int sell=price[i]+dfs(i+2,n,1,dp,price);
            int notsell=dfs(i+1,n,0,dp,price);
            profit=Math.max(sell,notsell);
        }
        return dp[i][buy]=profit;
    }
}