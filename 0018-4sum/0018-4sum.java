class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
         List<List<Integer>> l=new ArrayList<>();
         // here we need to iterate over two loops that is one for every element and other for next element of i
         // then perform 3 sum on second loop;
         //we need to fix i and j and then perform 3 sum;
         for(int i=0;i<n-3;i++){
            //to ensure that the array does not have duplicate;
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n-2;j++){
                //ensure that the array after thsi number does not have duplicate;
                if(j>i+1&&nums[j]==nums[j-1])continue;
                //do 3 sum now;
                int le=j+1;
                int h=n-1;
                while(le<h){
                    long sum=(long)nums[i]+nums[j]+nums[le]+nums[h];
                    List<Integer> a=new ArrayList<>();
                    if(sum==(long)target){
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[le]);
                        a.add(nums[h]);
                        l.add(a);
                        le++;
                        h--;
                        while(le<h&&nums[le]==nums[le-1])le++;
                        while(le<h&&nums[h]==nums[h+1])h--;
                    }
                    else if(sum<(long)target)le++;
                    else h--;
                }
            }
         }
         return l;
    }
}