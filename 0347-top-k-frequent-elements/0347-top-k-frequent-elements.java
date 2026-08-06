class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        if(k>n)return new int[]{};
        Map<Integer,Integer> m=new HashMap<>();
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->m.get(b)-m.get(a));
        for(int i=0;i<n;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m1:m.entrySet()){
            q.offer(m1.getKey());
        }
       int[] ans=new int[k];
       for(int i=0;i<k;i++){
        ans[i]=q.poll();
       }
       return ans;
    }
}