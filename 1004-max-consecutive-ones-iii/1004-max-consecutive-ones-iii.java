class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int max=0;
        if(k==n){
            return n;
        }
        int l=0;
        int h=n-1;
        int i=l;
        while(i<=h){
           if(nums[i]==0){
            count++;
           }
           while(count>k){
            if(nums[l]==0)count--;
            l++;
           }
           max=Math.max(max,i-l+1);
           i++;
        }
        return max;
    }
}