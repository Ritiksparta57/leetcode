class Solution {
    public int maxProfit(int[] prices) {
        //here we can do at max two transaction;
        //in bttbss 2 there were unlimited transaction;
        //also the transaction must not overlap that is buying on day 4 and selling on day 6;
        //if we are selecting above transaction then we must ensure no other transaction happens in between day 4 to day 6;
        //two things that is two cases one where we are allowed to buy a stock on that index and other is when we are not allowed to buy on that index;
        //when we select then we put buy as 0 which means sell therefore the next element sould be sold not bought;
        //if it was bttbss2 with infinite transaction we would have kept only two dimensions that is the index and the buy;
        //but here we are allowed to do only 2 transaction tharefore we have to introduce 3d which consists of ind,buy status,cap(or the limit to buy that is 2);
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        //n->ind,2->buy status,3->limit on transaction;
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++)Arrays.fill(dp[i][j],-1);
        }
        return dfs(0,n,1,2,dp,prices);
    }
    public int dfs(int i,int n,int buy,int cap,int[][][] dp,int[] price){
        //now here what we are gonna do is if the buy status is true and cap is there then we have two option ->1.Buy ,2.Not Buy(keeping cap,buy status unaffected);
        //similarly for selling it depends on us whether we want to choose to sell or buy;
        //bc can be two-> 1.i==n,2.cap==0;
        if(i==n){
            return 0;//as there is nothing to compare;
        }
        if(cap==0){
            return 0;//no more transactions allowed;
        }
        if(dp[i][buy][cap]!=-1)return dp[i][buy][cap];
        int profit=0;
        //here we start our transactions->
        //1.we are ALLOWED TO BUY->
        if(buy==1){
         //we have tow items either to buy or to sell;
         //not decrementing cap here because the transaction has not been completed;
         int webuy=-price[i]+dfs(i+1,n,0,cap,dp,price);//we bought no more buying allowed;
         int notbuy=0+dfs(i+1,n,1,cap,dp,price);
         profit=Math.max(webuy,notbuy);
        }
        else{
            //here also two condition one is to sell and other is to not sell;
            //here the transactions gets completed;
            int sell=price[i]+dfs(i+1,n,1,cap-1,dp,price);//we sold buying is allowed now;
            int notsell=0+dfs(i+1,n,0,cap,dp,price);
            profit=Math.max(sell,notsell);
        }
        return dp[i][buy][cap]=profit;
    }
}