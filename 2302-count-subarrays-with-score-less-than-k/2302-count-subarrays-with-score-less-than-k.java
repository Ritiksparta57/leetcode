class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long prod=1;
        long len=1;
        long sum=0;
        int l=0;
        int i=l;
        long count=0;
        while(i<n){
           sum+=(long)nums[i];
           prod=sum*len;
           while(prod>=k&&len>0){
            sum-=(long)nums[l];
            len--;
            prod=sum*len;
            l++;
           }
           count+=(long)i-l+1;
           len++;
           i++;
        }
        return count;
    }
}