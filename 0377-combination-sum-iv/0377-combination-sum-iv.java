class Solution {
    public int combinationSum4(int[] nums, int target) {
        //i think it is same as picking n coins in coin change but with a touch of target sum;
        //here is the catch when combination stars from 2 it will go in froward direction and will never come back to 1 but the problem mentions that it should also be added; 
        //thus we will have to run dfs through every element in the array;
        //see the major thing is we need to count only that combinations where target becomes 0;
        //there is absolutely no need of picking or not picking things thus using only one dimension target gives us in how many ways we reach a target;
        //example 4 is given as target so we calculate in how many ways we reach target ==1,2,3,4 and at last to calculate tar==0 we add no. of ways to 0 +nums of ways to 1;
        int n=nums.length;
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return dfs(0,target,n,dp,nums);
    }
    public int dfs(int i,int tar,int n,int[] dp,int[] nums){
        //base case is when tar ==0 and tar<0;
        if(tar==0)return 1;
        if(tar<0)return 0;
        if(dp[tar]!=-1)return dp[tar];
        //now here we only count the no. of ways to reach tar;
        int count=0;
        //we need different combination and we have i fixed so to try different we use a for loop;
        for(int j=0;j<n;j++){
            //so we just check ok by taking j and combining it with i,how many times we get 1;
            count+=dfs(j,tar-nums[j],n,dp,nums);
        }
        return dp[tar]=count;
    }
}