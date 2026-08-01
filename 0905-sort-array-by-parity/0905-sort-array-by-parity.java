class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int l=0;
        int h=n-1;
        int mid=l;
        while(mid<=h){
            if(nums[mid]%2!=0){
                int temp=nums[h];
                nums[h]=nums[mid];
                nums[mid]=temp;
                h--;
            }
            else mid++;
        }
        return nums;
    }
}