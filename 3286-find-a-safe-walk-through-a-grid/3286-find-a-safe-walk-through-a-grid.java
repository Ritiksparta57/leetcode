class pair{
    int row;
    int col;
    int d;
    public pair(int r,int c,int di){
        this.row=r;
        this.col=c;
        this.d=di;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};
        int[][] health1=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(health1[i],0);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->b.d-a.d);
        int sthealth=health-grid.get(0).get(0);
        if(sthealth<1)return false;
        pq.offer(new pair(0,0,sthealth));
        health1[0][0]=sthealth;
        while(!pq.isEmpty()){
           pair p=pq.poll();
           int r=p.row;
           int c=p.col;
           int d=p.d;
           if(d<health1[r][c])continue;
           for(int i=0;i<4;i++){
            int  nx=r+dx[i];
            int ny=c+dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<m){
                int new1=d-grid.get(nx).get(ny);
                if(new1>=1&&new1>health1[nx][ny]){
                    health1[nx][ny]=new1;
                    pq.offer(new pair(nx,ny,health1[nx][ny]));
                }
            }
           }
        }
        return health1[n-1][m-1]>=1?true:false;
    }
}