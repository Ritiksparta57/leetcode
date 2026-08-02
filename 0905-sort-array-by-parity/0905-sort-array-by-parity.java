class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int l=0;
        int h=n-1;
        int mid=l;//only for traversal;
        while(mid<=h){
            if(nums[mid]%2!=0){
                int temp=nums[mid];
                nums[mid]=nums[h];
                nums[h]=temp;
                h--;
                // no effect on mid as we do not know whether it is even or odd;
            }
            else mid++;//the mid is even i.e. where it should be;
        }
        return nums;
    }
}