class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
//                int prev=-1;
                max=Math.max(max,dfs(matrix,i,j,n,m,dp));
            }
        }
        return max;
    }
     public static int dfs(int[][] mat,int i,int j,int n,int m,int[][] dp){
        if(i<0||j<0||i>=n||j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=0;
        int down=0;
        int left=0;
        int right=0;
        if(i-1>=0&&mat[i-1][j]>mat[i][j]){
            up=1+dfs(mat,i-1,j,n,m,dp);
        }
        if(j-1>=0&&mat[i][j-1]>mat[i][j])left=1+dfs(mat,i,j-1,n,m,dp);
        if(j+1<m&&mat[i][j+1]>mat[i][j])right=1+dfs(mat,i,j+1,n,m,dp);
        if(i+1<n&&mat[i+1][j]>mat[i][j])down=1+dfs(mat,i+1,j,n,m,dp);
        return dp[i][j]=Math.max(1,Math.max(up,Math.max(left,Math.max(right,down))));
    }
}