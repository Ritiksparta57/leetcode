class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int prod=1;
        int l=0;
        int i=l;
        int count=0;
        while(i<n){
            prod=prod*nums[i];//take the prod;
            while(prod>=k){
                prod=prod/nums[l];
                l++;
            }
            count+=1+(i-l);
            i++;
        }
        return count;
    }
}