class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int ctar=0;
           for(int j=i;j<n;j++){
                if(nums[j]==target){
                    ctar++;
                }
                int val=j-i+1;
                if(ctar>(val/2)){
                    count++;
                }
           }
        }
        return count;
    }
}