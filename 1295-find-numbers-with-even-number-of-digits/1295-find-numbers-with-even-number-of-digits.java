class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int num:nums){
            int dig=count(num);
            if(dig%2==0)c++;
        }
        return c;
    }
    public int count(int n){
        int c=0;
        while(n>0){
            n=n/10;
            c++;
        }
        return c;
    }
}