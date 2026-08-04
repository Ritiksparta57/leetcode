class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l=new ArrayList<>();
        Set<Integer> st=new HashSet<>();
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
           if(max<num)max=num;
           if(min>num)min=num;
           st.add(num);
        }
        for(int i=min;i<=max;i++)if(!st.contains(i))l.add(i);
        return l;
    }
}