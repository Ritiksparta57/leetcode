class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> st=new HashSet<>();
        for(int num:nums){
            if(!st.contains(num))st.add(num);
            else return true;
        }
        return false;
    }
}