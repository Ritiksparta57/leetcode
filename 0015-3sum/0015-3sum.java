class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            // for first element;
            if(i>0&&nums[i]==nums[i-1])continue;
            //i is fixed and l is for i+1 and goes on and r is at last which goes till r>i;
            int le=i+1;
            int r=n-1;
            while(le<r){
                int sum=nums[i]+nums[le]+nums[r];
                 List<Integer> a=new ArrayList<>();
                if(sum==0){
                    a.add(nums[i]);
                    a.add(nums[le]);
                    a.add(nums[r]);
                    l.add(a);
                    le++;
                    r--;
                    while(le<r&&nums[le]==nums[le-1])le++;
                    while(le<r&&nums[r]==nums[r+1])r--;
                }
                else if(sum<0){
                    le++;
                }
                else r--;
            }
        }
        return l;
    }
}