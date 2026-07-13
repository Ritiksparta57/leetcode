class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int ind=0;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
           int num=nums[i];
           if(num<0){
             ind=(n+((i+num)%n))%n;
             res[i]=nums[ind];
           }
           else if(num>0){
            ind=(i+num)%n;
            res[i]=nums[ind];
           }
           else{
            ind=i;
            res[i]=nums[ind];
           }
        }
        return res;
    }
}