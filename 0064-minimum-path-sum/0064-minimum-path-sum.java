class Solution {
    public int minPathSum(int[][] grid) {
        //this we can do with dijkstra too;
        //but we are gonna do with dp and the reason is we can explore multiple moves from one cell at the same time;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(m-1,n-1,grid,dp);
    }
    public int dfs(int i,int j,int[][] grid,int[][] dp){
        //now we will dig deep down from last to first cell by giving it the minimum cost;
        //base case is if we have reached the last index;
        //and if we go beyond last index that is 0;
        if(i==0&&j==0){
            return grid[i][j];
        }
        //when it goes beyond 0 then give the path highest possible value so that we get the minimum value of all;
        if(i<0||j<0){
            return (int)1e9;
        }
        //we are not initializing dp with (int)1e9 as if we do so then the algo will be confused between the processed and unprocessed element;
        if(dp[i][j]!=-1)return dp[i][j];
        //now we have two ways possible opposite of what is given in question;
        //one is up and other is left;
        int up=0;
        int left=0;
        //since we are not counting steps thus we are not returning 1 or 0 so we are gonna add the total value of grid at that moment;
        up=grid[i][j]+dfs(i-1,j,grid,dp);
        left=grid[i][j]+dfs(i,j-1,grid,dp);
        return dp[i][j]=Math.min(up,left);
    }
}