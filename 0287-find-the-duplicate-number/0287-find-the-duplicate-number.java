class Solution {
    public int findDuplicate(int[] nums) {
        //since the array contains the numbers from 1 to n and n+1 integers;
        //now just make that index -1 which is pointed out by the number visited;
        // example when we visit number 2 then index 2 is marked -1;
        // thus if the same number appears anywhere then we say that the number which is pointing to that index is the one which appears double times;
         int n=nums.length;
         int i=0;
         while(i<n){
           int ind=Math.abs(nums[i]);
           if(nums[ind]<0)return ind;
           nums[ind]=-nums[ind];
           i++;
         }
         return -1;
    }
}