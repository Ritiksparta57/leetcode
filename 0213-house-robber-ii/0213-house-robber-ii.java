class Solution {
    public int rob(int[] nums) {
        //this question is same as house robber 1 but the thing is the houses are in a circle thus if last is touched then 1st cannot be touched;
        //so if we start from 0 then we end up picking n-1 at last and if starting from 1 then n is the last;
        // thus two different starting and ending points;
        //2 1-d dp is required;
        if(nums.length<=1)return nums[0];
        int n=nums.length;
        int[] dp0=new int[n];
        int[] dp1=new int[n];
        Arrays.fill(dp0,-1);
        Arrays.fill(dp1,-1);
        int max=Math.max(dfs(0,n-2,dp0,nums),dfs(1,n-1,dp1,nums));
        return max;
    }
    public int dfs(int s,int e,int[] dp,int[] nums){
        if(s==e)return nums[s];//the last possible index;
        if(s>e)return 0;
        if(dp[s]!=-1)return dp[s];
        //skipping can be possible but the last index it chooses if 0 is first is n-2 as if n-1 is taken then for sure alarm will be on;
        int not=dfs(s+1,e,dp,nums);
        int take=nums[s]+dfs(s+2,e,dp,nums);
        return dp[s]=Math.max(not,take);
    }
}