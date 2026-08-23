class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //if the question would have been subsequence non continuous we would have done lis;
        //now the question has became very easy;
        int n=nums.length;
        int len=1;
        int l=1;
        int h=n-1;
        int count=1;//count and len is set 1 as at least that element will be an lis;
        while(l<=h){
            if(nums[l]>nums[l-1]){
             count++;
            }
            else{
                count=1;
            }
            len=Math.max(len,count);
            l++;
        }
        return len;
    }
}