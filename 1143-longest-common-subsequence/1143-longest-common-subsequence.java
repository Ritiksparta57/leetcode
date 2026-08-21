class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        //well the major thing is if the items match then we increment both the pointers from both the strigns else we decrement any one of them and see if they match;
        //and the relationship will be in between the ith character of text1 and the jth character of text2;
        //our dp will store the length of longest cmmon subsequence upto that index in text1 and text2;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(0,0,dp,text1,text2,m,n);
    }
    public int dfs(int i,int j,int[][] dp,String s,String t,int m,int n){
        //the base case will be when they reach the last index;
        if(i>=m||j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        char ch=s.charAt(i);
        char c=t.charAt(j);
        int l=0;
        //we need to count when the character is similar;
        //so we add 1 to l whenever the characters are similar;
        if(ch==c)l=1+dfs(i+1,j+1,dp,s,t,m,n);
        else{
            l=Math.max(dfs(i+1,j,dp,s,t,m,n),dfs(i,j+1,dp,s,t,m,n));
        }
        return dp[i][j]=l;
    }
}