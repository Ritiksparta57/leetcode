class Solution {
    public int combinationSum4(int[] nums, int target) {
        //similar to cs3 here we get array of distinct integers;
        //but in cs3 the direction of flow was given forward and we needed to take only k elements;
        //also we can use the given element multiple times;
        //thus there is a huge difference;
        //hence it is similar to coin change of dp;
        //but with a trick of going back to the previous other numbers or elements;
        //thus we are gonna write a dp which tells us how many ways we are goin to reach 0 to target;
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return dfs(0,nums.length,target,dp,nums);
     }
     public int dfs(int i,int n,int tar,int[] dp,int[] nums){
        //the base case is when we reach the tar;
        if(tar==0)return 1;
        if(tar<0)return 0;
        if(i>=n)return 0;
        if(dp[tar]!=-1)return dp[tar];
        int count=0;
        for(int j=0;j<n;j++){
            count+=dfs(j,n,tar-nums[j],dp,nums);
        }
        return dp[tar]=count;
     }
}