class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int prod=1;
        int l=0;
        int i=l;
        int count=0;
        while(i<n){
            prod=prod*nums[i];//take the prod;
            while(prod>=k){//now while the prod is greater or equal to k till then just divide the prod by num[l] and keep increasing l and dividing prod untill prod<k;
                prod=prod/nums[l];
                l++;
            }
            // no. of subarrays =add every single time the length of subarray 
            count+=1+(i-l);
            i++;//increment the i
        }
        return count;
    }
}