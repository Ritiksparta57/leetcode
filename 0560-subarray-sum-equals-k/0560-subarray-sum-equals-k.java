class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum-k;
            if(m.containsKey(rem)){
                count+=m.get(rem);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return count;
    }
}