class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum=0;
        int t=(int)Math.min(k,(int)Math.max(0,mul-1));
        int ind=nums.length-1;
        int cur=mul;
       for(int i=0;i<t;i++){
           sum+=1L*nums[ind--]*cur--;
       }
        for(int i=0;i<k-t;i++){
            sum+=nums[ind--];
        }
        return sum;
    }
}