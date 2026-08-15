class pair{
    int x;
    int y;
    int dist;
    public pair(int i,int j,int w){
        this.x=i;
        this.y=j;
        this.dist=w;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[] dx={1,1,1,-1,-1,-1,0,0};
        int[] dy={-1,0,1,-1,0,1,1,-1};
        //the question is why dp cannot work?
        //answer is the dp needs a static answer to its neighbors but since in a graph the neighbors distance can change at any moment with discovery of new nodes;
        //thus it is impossible for dp to determine the actual distance;
        //therefore we use bfs or dijkstra;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        if(grid[0][0]!=0||grid[n-1][n-1]!=0)return -1;
        dist[0][0]=0;
        q.offer(new pair(0,0,0));
        while(!q.isEmpty()){
            int s=q.size();
            for(int k=0;k<s;k++){
                pair p=q.poll();
                int x=p.x;
                int y=p.y;
                int d=p.dist;
                if(dist[x][y]<d)continue;
                for(int z=0;z<8;z++){
                    int nx=x+dx[z];
                    int ny=y+dy[z];
                    int dis=d+1;
                    if(nx>=0&&nx<n&&ny>=0&&ny<n&&grid[nx][ny]==0&&dis<dist[nx][ny]){
                        dist[nx][ny]=dis;
                        q.offer(new pair(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }
        //need to return dist[n][n]+1 as we need to count the very first 0 too;
        return dist[n-1][n-1]!=Integer.MAX_VALUE?dist[n-1][n-1]+1:-1;
    }
}