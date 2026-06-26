class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visit=new boolean[row][col];
        int perimeter=0;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1&&!visit[i][j]){
                    count=dfs(grid,row,col,visit,dx,dy,i,j);
                    perimeter=count;
                }
            }
        }
        return perimeter;
    }
    public int dfs(int[][] grid,int r,int c,boolean[][] visited,int[] dx,int[] dy,int i,int j){
        visited[i][j]=true;
        int count=0;
        for(int k=0;k<4;k++){
            int nx=i+dx[k];
            int ny=j+dy[k];
            if(nx<0||ny<0||nx>=r||ny>=c||grid[nx][ny]==0){
                count+=1;
            }
            else if(nx>=0&&nx<r&&ny>=0&&ny<c&&grid[nx][ny]==1&&!visited[nx][ny]){
                count+=dfs(grid,r,c,visited,dx,dy,nx,ny);
            }
        }
        return count;
    }
}