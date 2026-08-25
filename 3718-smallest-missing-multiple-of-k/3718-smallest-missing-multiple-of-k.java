class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> st=new HashSet<>();
        for(int num:nums)st.add(num);
        for(int i=1;i<=n;i++){
            int mul=k*i;
            if(!st.contains(mul))return mul;
        }
        return k*(n+1);
    }
}