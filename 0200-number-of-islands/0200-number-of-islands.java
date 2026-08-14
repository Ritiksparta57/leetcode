class Solution {
    public int numIslands(char[][] grid) {
        //we need to connect no of 1's and then count the islands;
        int m=grid.length;
        int n=grid[0].length;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        boolean[][] vis=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&vis[i][j]==false){
                    count++;
                    dfs(i,j,dx,dy,vis,grid,m,n);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,int[] dx,int[] dy,boolean[][] vis,char[][] grid,int m,int n){
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            int nx=i+dx[k];
            int ny=j+dy[k];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]=='1'&&vis[nx][ny]==false){
                dfs(nx,ny,dx,dy,vis,grid,m,n);
            }
        }
    }
}