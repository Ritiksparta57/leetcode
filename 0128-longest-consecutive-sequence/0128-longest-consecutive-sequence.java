class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> st=new HashSet<>();
       int n=nums.length;
       for(int i=0;i<n;i++){
        if(!st.contains(nums[i]))st.add(nums[i]);
       } 
        int len=0;
        for(int num:st){//WE  just check in the set of al letters not the whole array;
            if(!st.contains(num-1)){// if the num-1 is there inset then the num is not the starting point of sequence thus we will surely visit the num-1 and there we wil take the longest;
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