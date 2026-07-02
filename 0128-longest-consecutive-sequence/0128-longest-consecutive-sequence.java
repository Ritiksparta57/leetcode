class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> st=new HashSet<>();
       int n=nums.length;
       for(int i=0;i<n;i++){
        if(!st.contains(nums[i]))st.add(nums[i]);
       } 
        int len=0;
        for(int num:st){
            if(!st.contains(num-1)){
            int count=0;
            int current=num;
            while(st.contains(current)){
                count++;
                current=current+1;
            }
            len=Math.max(len,count);
        }
        }
        return len;
    }
}