class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //here in this question it is similar to unique paths 1 where we had free hand to choose any cell in up or left manner but here we have an obstacle which we can surely deal with;
        //only one change in base case where i or j<0 ther we need to add one more that the path which contains an obstacle is not a valid one so we leave it and return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(m-1,n-1,dp,obstacleGrid);
    }
    public int dfs(int i,int j,int[][] dp,int[][] og){
        //same bc as unique path 1 just change in second bc with og not being 1;
        if(i==0&&j==0)return 1;
        if(i<0||j<0||og[i][j]==1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=0;
        int left=0;
        up+=dfs(i-1,j,dp,og);
        left+=dfs(i,j-1,dp,og);
        return dp[i][j]=up+left;
    }
}