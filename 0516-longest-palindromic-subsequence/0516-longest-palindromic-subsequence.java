class Solution {
    public int longestPalindromeSubseq(String s) {
        //see in lcs we find how many letters match so that we can say the strings are equal;
        //here in lps it is the same just revrse the string and get another string;
        //now after comparing each leeters in string we may get a substring of various letters in the strign whcih might be equal;
        //these are actaully the subsequences and since the strings are reversed thus the first is equal to last of first string;
        //And so on,Hence we can conclude that the no. of characters matching in the strings are all part of a palindrome thus making it the longest one;
        StringBuilder sb=new StringBuilder(s);
        String s1=sb.reverse().toString();
        int n=s.length();
        //now we jsut need to compare both strings using lcs;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(0,0,n,dp,s,s1);
    }
    public int dfs(int i,int j,int n,int[][] dp,String s,String s1){
        //base case is when i and j goes beyond or equal to n then there is nothing to compare thus return 0;
        if(i>=n||j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        //now comes the matching and not matching;
        int l=0;//calculates length;
        char ch=s.charAt(i);
        char c=s1.charAt(j);
        if(ch==c)l=1+dfs(i+1,j+1,n,dp,s,s1);
        else{
            l=Math.max(dfs(i+1,j,n,dp,s,s1),dfs(i,j+1,n,dp,s,s1));
        }
        return dp[i][j]=l;
    }
}