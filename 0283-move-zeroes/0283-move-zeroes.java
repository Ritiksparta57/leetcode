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
        //optimal is ->1.find first occurance of zero;
        //2.take j+1 and iterate over i=j+1 to n and select those numbers which are not 0 and tehn swap and increase j by 1; 
    }
}