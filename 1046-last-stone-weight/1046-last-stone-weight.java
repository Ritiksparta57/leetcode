class Solution {
    public int lastStoneWeight(int[] stones) {
        //wht we have here is something like if we take two biggest no. and then store there difference in queue and it goes on until last stone remains in the queue;
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        for(int a:stones)q.offer(a);
        while(q.size()>1){
          int x=q.poll();
          int y=q.poll();
          q.offer(x-y);
        }
        int ans=0;
        if(q.size()==1)ans=q.poll();
        return ans;
    }
}