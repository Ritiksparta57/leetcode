class Solution {
    public int longestConsecutive(int[] nums) {
       int n=nums.length;
       //we just need to care about that number from where the sequence will start;
       //we will set up a set in which all no. will be stored and then we will search for the number in set which do not have number-1 in the set and that is where the sequnece starts from;
       //then we run a while loop to find the len for the sequnce that start from that number 
       //that is done using while(st.contains(number+1));
       if(n==0)return 0;
       Set<Integer> st=new HashSet<>();
       for(int num:nums)st.add(num);
       int maxlen=1;
       for(int num:st){
          int number=num;
          int len=1;
          if(!st.contains(number-1)){
            while(st.contains(number+1)){
               len++;
               number++;
            }
          }
          maxlen=Math.max(maxlen,len);
       } 
       return maxlen;
    }
}