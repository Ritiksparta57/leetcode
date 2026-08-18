class Solution {
    public int largestInteger(int[] nums, int k) {
        //here we will use hashmap which will store the frequency of any element permanently;
        int n=nums.length;
        Map<Integer,Integer> m=new HashMap<>();
        //we need to build subarray from every character;
        for(int i=0;i<n-k+1;i++){
         Set<Integer> st=new HashSet<>();
            for(int j=i;j<i+k;j++){
                if(!st.contains(nums[j])){
                    st.add(nums[j]);
                m.put(nums[j],m.getOrDefault(nums[j],0)+1);
                }
            }
        }
        //now let us traverse through map finding the number with exactly 1 occurance;
        int ans=-1;
        for(Map.Entry<Integer,Integer> newm:m.entrySet()){
            int v=newm.getValue();
            int u=newm.getKey();
            if(v==1){
               if(u>=ans)ans=u;
            }
        }
        return ans;
    }
}