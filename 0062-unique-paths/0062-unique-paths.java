class Solution {
    public int uniquePaths(int m, int n) {
        //see this is a question of take or not take a path again;
        //we can start from 0 and go till end or from end to 0;
        // now the major part is that the robot can move two steps from every cell;
        //therefore let us start from n-1 and reach upto 0 for ease of travelling;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(m-1,n-1,dp);
    }
    public int dfs(int i,int j,int[][] dp){
        //base cases are:->
        //1.when i and j both reaches 0 then it is 1(i.e. a way to reach the end is found);
        //2.and if i and j any one of them goes below 0 then there is no way through it therefore return 0;
        if(i==0&&j==0)return 1;
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        //now here comes the main logic from every step we can either go up or left(opposite of what it is given as we are also going in opposite direction);
        int up=0;
        int left=0;
        up+=dfs(i-1,j,dp);
        left+=dfs(i,j-1,dp);
        return dp[i][j]=up+left;
    }
}