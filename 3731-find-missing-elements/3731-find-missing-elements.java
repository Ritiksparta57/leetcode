class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        Arrays.sort(nums);
        int s=nums[0];
        int e=nums[n-1];
        Set<Integer> st=new HashSet<>();
        for(int num:nums)st.add(num);
        for(int i=s;i<=e;i++){
            if(!st.contains(i)){
                l.add(i);
            }
        }
        return l;
    }
}