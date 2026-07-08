class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)nums[i]=-1;
        }
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(m.containsKey(sum)){
               max=Math.max(max,i-m.get(sum));
            }
            else{
             m.put(sum,i);
            }
        }
      return max;
    }
}