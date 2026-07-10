class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        //instead of finding what all to remove we find what not to remove;
        //for example we need to find the length of subarray whose sum is=(total-x);cause that is all we would have at the end;
        int sum=add(nums);
        int target=sum-x;//this is the target that we will have after removing the x subarrays;
        if(target<0)return -1;//cause u are asking x greater than the whole sum of array;
        if(target==0)return n;//cause the sum==x;
        //start finding the length of longest subarray with sum equal to target as the longest will give us the minimum no. of removals from array;
        //apply sliding window;
        int l=0;
        int maxlen=0;
        int i=l;
        int sumoftarget=0;
        while(i<n){
            sumoftarget+=nums[i];
            while(sumoftarget>target){
                sumoftarget-=nums[l];
                l++;
            }
            if(sumoftarget==target)maxlen=Math.max(maxlen,i-l+1);
            i++;
        } 
        return (n-maxlen)==n?-1:n-maxlen;//as these all no.s we have to remove;
    }
    public int add(int[] nums){
        int n=nums.length;
        int sum=0;
        for(int a:nums)sum+=a;
        return sum;
    }
}