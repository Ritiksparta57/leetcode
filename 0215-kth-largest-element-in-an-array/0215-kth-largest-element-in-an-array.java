class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->a-b);
        // for(int i=0;i<n;i++)q.offer(nums[i]);
        // while(k-1>0){
        //    q.poll();
        //    k--;
        // }
        // int ans=q.poll();
        // return ans;
        for(int i=0;i<n;i++){
            q.offer(nums[i]);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.poll();
    }
}