class Solution {
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //this is similar to unique path just the difference that we need to return 1 when we reach out of boundary;
        //also there is a constraint maxmove which basically tells us that we need to do it before this many moves;
        //one thing i left which was becoming an obstacle is the ball depends on r,c as well as moves as on the same row and same col we can reach from any point and with any no. of moves so the dp state needs to be dependent on move too as this removes the possibility of conflict;
        int[][][] dp=new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){for(int j=0;j<n;j++){Arrays.fill(dp[i][j],-1);}}
        return dfs(startRow,startColumn,m,n,dp,maxMove);
    }
    public int dfs(int r,int c,int m,int n,int[][][] dp,int move){
        //base case is when we reach out of boundary we return 1;
        if(r<0||c<0||r>=m||c>=n)return 1;
        //also when max move is over;
        if(move==0){
            if(r<0||c<0||r>=m||c>=n)return 1;
            else return 0;
        }
        if(dp[r][c][move]!=-1)return dp[r][c][move];
        //now we check for going up,down,left,right;
        int up=0;
        int down=0;
        int left=0;
        int right=0;
        up+=dfs(r-1,c,m,n,dp,move-1);
        down+=dfs(r+1,c,m,n,dp,move-1);
        left+=dfs(r,c-1,m,n,dp,move-1);
        right+=dfs(r,c+1,m,n,dp,move-1);
        return dp[r][c][move]=(int)(((long)up+left+down+right)%mod);
    }
}