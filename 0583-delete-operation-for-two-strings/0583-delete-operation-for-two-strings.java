class Solution {
    public int minDistance(String word1, String word2) {
        //here we just need to find how many letters are equal in both the strings;
        //so after finding it we may subtract and find the non equals which we may have to remove from both strings and add them;
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        int eq=dfs(0,0,m,n,dp,word1,word2);
        return (m-eq)+(n-eq);
    }
    public int dfs(int i,int j,int m,int n,int[][] dp,String s,String s1){
        if(i>=m||j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        char ch=s.charAt(i);
        char c=s1.charAt(j);
        int l=0;
        if(ch==c)l=1+dfs(i+1,j+1,m,n,dp,s,s1);
        else{
            l=Math.max(dfs(i+1,j,m,n,dp,s,s1),dfs(i,j+1,m,n,dp,s,s1));
        }
        return dp[i][j]=l;
    }
}