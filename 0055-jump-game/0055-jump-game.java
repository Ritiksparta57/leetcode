class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        if(n<=1)return true;
        if(nums[0]==0)return false;
        int i=0;
        while(i<n-1){
            //calculate the reach for every index;
            int reach=nums[i]+i;
            //if the reach is less than max then what is the need to travel again on that;
            if(max>reach){i++;continue;}
            //if max<reach then maxke max reach
            max=reach;
            // if the max is still less than n-1 and the number on which max became peak is 0 then we cannot move any futher in array thus no possible to reach n-1;
            if(max<n-1&&nums[i]==0)return false;
            //if the max has reached end or became greater then we have raeched our conclusion;
            if(max>=n-1)return true;
            //increment to test every element;
            i++;
        }
        //if i has ended and still unable to go reach n-1 then return false;
        return false;
    }
}