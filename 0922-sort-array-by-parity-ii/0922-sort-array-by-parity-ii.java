class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int l=0;
        int h=1;
        while(l<n&&h<n){
            if(nums[l]%2!=0){
                int temp=nums[l];
                nums[l]=nums[h];
                nums[h]=temp;
                h+=2;//the odd no. is at odd index and not increasing l as we do not know whether the element swapped is even or odd therefore as we are sure of h we may say that go on increasing h until all index h is odd;
            }
            else l+=2;// else we know that l is even;
        }
        return nums;
    }
}