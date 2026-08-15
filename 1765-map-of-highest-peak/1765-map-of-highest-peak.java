class Solution {
    public int[][] highestPeak(int[][] mat) {
        //here 1 is water and 0 is land cell;
        //so the focus is now on 1;
        int m=mat.length;
        int n=mat[0].length;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    dist[i][j]=0;
                    mat[i][j]=-1;
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int[] coor=q.poll();
                int x=coor[0];
                int y=coor[1];
                for(int k=0;k<4;k++){
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n&&mat[nx][ny]==0){
                        mat[nx][ny]=-1;
                        dist[nx][ny]=dist[x][y]+1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return dist;
    }
}