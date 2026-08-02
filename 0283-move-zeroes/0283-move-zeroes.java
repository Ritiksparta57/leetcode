class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int l=0;
        int h=l+1;
        while(l<n&&h<n){
            if(nums[l]==0){
                if(nums[h]!=0){
                    int temp=nums[l];
                    nums[l]=nums[h];
                    nums[h]=temp;
                    l++;
                    h++;
                }
                else h++;
            }
           else{
            l++;
            h++;
           }
        }
    }
}