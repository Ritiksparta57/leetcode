class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //since we only need to find one transaction which has the max profit thus we won't need dp in 2d like dp[i][buy];
        //we just need to keep track of the minimum price and find the max profit after that;
        int min=prices[0];
        int cost=0;
        for(int i=1;i<n;i++){
          //if the prices at i is less than min then set min to current i;
          if(min>prices[i])min=prices[i];
          // else if price at i is greater then find the max profit;
          else cost=Math.max(cost,prices[i]-min);
        }
        return cost;
    }
}