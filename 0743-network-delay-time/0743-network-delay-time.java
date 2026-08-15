class pair{
    int v;
    int w;
    public pair(int v1,int w1){
        this.v=v1;
        this.w=w1;
    }    
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //we have got a source k;
        //now all we got to do is to make an adjacency list and then calculate the distance;
        //but since we got weight w and node v then we have to make pair to store in the list for that parent node; 
        //the nodes are starting from 1 thus to store it we will use u-1 to keep it from 0;
        List<List<pair>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
          l.add(new ArrayList<>());
        }
        for(int[] time:times){
            int x=time[0]-1;
            int y=time[1]-1;
            int w=time[2];
            l.get(x).add(new pair(y,w));
        }
        //since we need to calculate distance so we need to hve a distance array;
        //we need to put all nodes at inf;
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        //now we have a starting node k;
        //to traverse it and perform minimum distance calculation we need dijkstra;
        //thus we need a queue to perform it;
        //in priorityQueue we will basically add the pair in ascending order of their diatance as it becomes easier for us to get the least distance real quick;
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.w-b.w);
        //since the given is 1 indexed but we need 0 indexed thus instead of k we will use k-1;
        //we need to store the starting point in q and its dist as 0;
        q.offer(new pair(k-1,0));
        dist[k-1]=0;
        while(!q.isEmpty()){
            //since we are exploring the child one at a time so there can be many;
            int s=q.size();
            for(int j=0;j<s;j++){
                pair p=q.poll();
                int u=p.v;
                int w=p.w;
                if(dist[u]<w)continue;//we already have the least value of u possible till this time so why waste out time in calculating the greater distance for v;
                for(pair child:l.get(u)){
                    int v=child.v;
                    int d=child.w;
                    int dis=d+w;
                    //if we have a lesser distance than dist[v] then make it the dist[v] and offer the pair for less distance calculation;
                    if(dis<dist[v]){
                        dist[v]=dis;
                        q.offer(new pair(v,dist[v]));
                    }
                }
            }
        }
        //now in the question if asked whether all are visited or not;
        //if yes then give the max time else give -1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}