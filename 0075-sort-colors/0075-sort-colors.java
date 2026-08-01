class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0;
        int h=n-1;
        int mid=l;
        while(mid<=h){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[l];
                nums[l]=temp;
                l++;
                mid++;//mid is done at that index as 0 is placed at correct pos and if the swapped values is1 then the 1 should be at mid which is done;
            }
            else if(nums[mid]==1){
              mid++;// 1 is at mid;
            }
            else{
                int temp=nums[mid];
                nums[mid]=nums[h];
                nums[h]=temp;
                h--;//no mid is involved as mid is yet to be processed;
            }
        }
    }
}