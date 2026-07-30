class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            if(m.containsKey(nums[i])&&i-m.get(nums[i])<=k){
                return true;
            }
            else{
                m.put(nums[i],i);
            }
        }
        return false;
    }
}