class Solution {
    public int jump(int[] nums) {
       int n=nums.length; 
       //in jump game 1 we needed to tell whether we can reach the end or not;
       //here it is already given that we will reach the end;
       //the only thing which we need to calculate is the no. of steps;
       if(n<=1)return 0;
       int count=0;
       int max=0;
       int i=0;
       while(i<n){
        int reach=nums[i]+i;
        if(reach<max){
         i++;
         continue;
        }
        if(i<=max){
           int j=i+1;
           while(j<=max){
             int r=nums[j]+j;
             if(r>reach)reach=r;
             j++;
           }
           max=reach;
           count++;
           if(max>=n-1)return count;
        }
       }
       return 0;
    }
}