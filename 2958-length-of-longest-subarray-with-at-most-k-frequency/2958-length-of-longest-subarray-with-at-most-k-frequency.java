class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> m=new HashMap<>();
        int l=0;
        int h=n-1;
        int i=l;
        int maxlen=0;
        while(i<=h){
          int len=0;
          int num=nums[i];
          m.put(num,m.getOrDefault(num,0)+1);
          while(m.get(num)>k){
            m.put(nums[l],m.get(nums[l])-1);
            if(m.get(nums[l])==0)m.remove(nums[l]);
            l++;
          }
          len=i-l+1;
          maxlen=Math.max(len,maxlen);
          i++;
        }
        return maxlen;
    }
}