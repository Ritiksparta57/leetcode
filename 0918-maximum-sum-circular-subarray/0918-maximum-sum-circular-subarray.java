class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int total=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            total+=nums[i];
            if(sum<nums[i])sum=nums[i];
            if(max<sum){
                max=sum;
            }
        }
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>nums[i])sum=nums[i];
            if(min>sum)min=sum;
        }
        if(max<0)return max;
        max=Math.max(max,total-min);
        return max;
    }
}