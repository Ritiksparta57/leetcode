class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        //the adjacent houses cannot be robbed and we can start robbing from any position and skip in between any house;
        //1d-dp will be the best choice.
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return dfs(0,n-1,dp,nums);
    }
    public int dfs(int i,int n,int[] dp,int[] nums){
        //base case is the moment we reach the last index we return the value of it;
        if(i==n){
            return nums[i];
        }
        if(i>n)return 0;//if i>n then there is nothing to compare;
        if(dp[i]!=-1)return dp[i];
        //now we can take an index or we skip it;
        //so we need to calculate in each situation which is giving more profit;
        //if not taking then just move i to i+1;
        int not=0+dfs(i+1,n,dp,nums);
        //if we are taking then move i to i+2 as adjacency should remain;
        int take=nums[i]+dfs(i+2,n,dp,nums);
        return dp[i]=Math.max(take,not); 
    }
}