class Solution {
    public boolean canPartition(int[] nums) {
        //this basically tells us whether the sum of the array is even or odd;
        //if odd then it is not possible to seperate the array in two equal sum partition;
        //if even then there is a possibility;
        //here we can easily divide the sum by 2 nd check if any subsequence not subarray of array is there where the elements make such sum or not;
        //cannot be done greedily as we do not know how many elements are possible to have such;
        //thus using dp;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)sum+=nums[i];
        if(sum%2!=0)return false;
        int target=sum/2;
        //now from here this question has become similar to coin change question where only one condition is changed that is we cannot take a coin multiple times;
        //everything else remains same that is we have to make the sum of elements equal to target;
        Boolean[][] dp=new Boolean[n][target+1];
        // for(int i=0;i<n;i++)Arrays.fill(dp[i],null); Boolean is already initialized with null
        return dfs(n-1,target,dp,nums);
    }
    public boolean dfs(int i,int target,Boolean[][] dp,int[] nums){
         //two base condition;
         //1.when tar==0;
         //2.when i==0;
         if(target==0)return true;
         if(i==0){
            if(target==nums[i])return true;
            else return false;
         }
         if(dp[i][target]!=null)return dp[i][target];
         //we can pick or not pick any index;
         boolean not=dfs(i-1,target,dp,nums);
         boolean pick=false;
         if(target>=nums[i]){
            pick=dfs(i-1,target-nums[i],dp,nums);
         }
         return dp[i][target]=not||pick;
    }
}