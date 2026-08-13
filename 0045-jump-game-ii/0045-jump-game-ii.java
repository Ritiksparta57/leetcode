class Solution {
    public int jump(int[] nums) {
       int n=nums.length; 
       //in jump game 1 we needed to tell whether we can reach the end or not;
       //here it is already given that we will reach the end;
       //the only thing which we need to calculate is the no. of steps;
       //after calculating each jump we have a reach (maximum) thus until i is less than max we iterate over the values in between i and max;
       //if the reach of them is more than reach(of i which is proven to be greater than max) then we replace reach with r(calculated one)then after iterating till max we replace max with highest reach;
       //also increment count as we have taken a jump and then check whether max has reached the end;
       //if so then return count;
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