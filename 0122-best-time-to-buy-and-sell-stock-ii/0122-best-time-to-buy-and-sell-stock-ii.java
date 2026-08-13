class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //we are thinking of immediate profit;
        //we cannot hold more than one stock a day;
        //therefore we need to sell the stock at the day we found a better deal;
        int[] profit=new int[n];
        profit[0]=0;
        for(int i=1;i<n;i++){
          int diff=prices[i]-prices[i-1];
          profit[i]=diff;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(profit[i]>0)ans+=profit[i];
        }
        return ans;
    }
}