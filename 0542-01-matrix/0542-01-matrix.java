class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //instead of focussing on 1 focus on 0 as if we look on 1 then in queue we will be finding 1's and then go on incrementing dist by 1 and adding in queue only when neigh is 1 but in reality the if there is a nearest 0 at a distance of less than the upcoming distance through 1 then it will be discarded;
        //so let us do one thing we add the indexes of 0 in queue and in place of them place -1;
        //then traverse through them;
        //if we find a 1 then we increment that distance by 1 and replace it with -1;
        int m=mat.length;
        int n=mat[0].length;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
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
                    if(nx>=0&&nx<m&&ny>=0&&ny<n&&mat[nx][ny]==1){
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