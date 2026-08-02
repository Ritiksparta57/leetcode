class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int l=0;
        int h=1;
        while(l<n&&h<n){
            if(nums[l]%2!=0){
                int temp=nums[h];
                nums[h]=nums[l];
                nums[l]=temp;
                h+=2;
            }
            else{
                l+=2;
            }
        }
        return nums;
    }
}