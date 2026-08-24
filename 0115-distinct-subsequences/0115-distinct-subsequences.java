class Solution {
    public int numDistinct(String s, String t) {
       int m=s.length();
       int n=t.length();
       if(s.equals(t))return 1;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(0,0,m,n,s,t,dp);
    }
    public int dfs(int i,int j,int m,int n,String s,String t,int[][] dp){
        if(i<m){
            if(j>=n)return 1;
        }
        if(i>=m){
            if(j>=n)return 1;
            else return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        char ch=s.charAt(i);
        char c=t.charAt(j);
        int take=0;
        int not=0;
        if(ch==c){
            take+=dfs(i+1,j+1,m,n,s,t,dp);
            not+=dfs(i+1,j,m,n,s,t,dp);
        }
        else{
            not+=dfs(i+1,j,m,n,s,t,dp);
        }
        return dp[i][j]=not+take;
    }
}