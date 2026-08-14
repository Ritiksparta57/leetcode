class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        //i think bfs is the only answer as we need to count how many 2's are there in one iteration and thus converting 1 to 2 in that
        //as in dfs it is not possible to count the minutes;
        boolean[][] vis=new boolean[m][n];
        int count=-1;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
                else if(grid[i][j]==1)fresh++;
            }
        }
        if(fresh==0)return 0;
         //see the most important thing to remember here is for every iteration of 2 we are continuously removing used 2's;
         //now for every iteration we get a bunch of 2's coordinate;
         //now we calculate the count or minutes in such a way that for every iteration of till the q is not empty we just go through all the twos and make every 1->2 ;
        while(!q.isEmpty()){
            int s=q.size();
            count++;
            for(int k=0;k<s;k++){
            int[] coor=q.poll();
            int x=coor[0];
            int y=coor[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==1){
                    grid[nx][ny]=2;
                    //also we are making a fresh one rotten then reduce no. of fresh by one;
                    fresh--;
                    vis[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
                else if(nx>=0&&nx<m&&ny>=0&&ny<n&&vis[nx][ny]==false&&grid[nx][ny]==2){
                    vis[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
                else if(nx>=0&&nx<m&&ny>=0&&ny<n&&vis[nx][ny]==false&&grid[nx][ny]==0)continue;
            }
        }
        }
        return fresh==0?count:-1;
    }
    
}