class pair{
    int r;
    int c;
    int t;
    public pair(int r1,int c1,int t1){
        this.r=r1;
        this.c=c1;
        this.t=t1;
    }
}
class Solution {
    public int minTimeToReach(int[][] move) {
        int m=move.length;
        int n=move[0].length;
        int[][] time=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(time[i],Integer.MAX_VALUE);
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.t-b.t);
        time[0][0]=0;
        q.offer(new pair(0,0,0));
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int t=p.t;
            if(t>time[r][c])continue;
            for(int i=0;i<4;i++){
                int nx=r+dx[i];
                int ny=c+dy[i];
                if(nx<m&&nx>=0&&ny>=0&&ny<n){
                   int ti=Math.max(t,move[nx][ny])+1;
                   if(time[nx][ny]>ti){
                    time[nx][ny]=ti;
                    q.offer(new pair(nx,ny,time[nx][ny]));
                   }
                }
            }
        }
        return time[m-1][n-1];
    }
}