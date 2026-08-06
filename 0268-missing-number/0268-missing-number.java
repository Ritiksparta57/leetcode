class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=((n+1)*(n))/2;
        int s=0;
        for(int i=0;i<n;i++)s+=nums[i];
        return sum-s;
    }
}