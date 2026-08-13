class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        if(n<=1)return true;
        if(nums[0]==0)return false;
        int i=0;
        while(i<n-1){
            int reach=nums[i]+i;
            if(max>reach){i++;continue;}
            max=reach;
            if(max<n-1&&nums[i]==0)return false;
            if(max>=n-1)return true;
            i++;
        }
        return false;
    }
}