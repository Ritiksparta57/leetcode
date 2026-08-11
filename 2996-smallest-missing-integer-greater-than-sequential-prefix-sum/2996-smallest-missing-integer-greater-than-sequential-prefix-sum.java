class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        Set<Integer> st=new HashSet<>();
        for(int num:nums)st.add(num);
        int sum=nums[0];
        int i=1;
        while(i<n&&nums[i]==nums[i-1]+1){
          sum+=nums[i];
          i++;
        }
        while(st.contains(sum))sum++;
        return sum;
    }
}