class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        //let us do dp that is if aba is palindrome then can xabax be a palindrome i.e. we are going to check that if s[i]==s[j] then were dp[i+1][j-1]=true(i.e. i+1,j-1 is the just before in between character ) and if they are also similar then we have a palindrome; 
        Boolean[][] dp=new Boolean[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],null);
       //let us call dfs for all substrings;
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            boolean trufal=dfs(i,j,s,dp);
        }
       }
       int firstt=0;
       int lastt=0;
       int maxlen=1;
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(dp[i][j]!=null&&dp[i][j]){
                int len=j-i+1;
                if(len>maxlen){
                    firstt=i;
                    lastt=j;
                    maxlen=len;
                }
            }
        }
       }
       String ans=s.substring(firstt,lastt+1);
       return ans;
    }
    public boolean dfs(int i,int j,String s,Boolean[][] dp){
        //the middle elemen;
        // as in even case both the centres are opposite to each other;
        if(i>=j)return dp[i][j]=true;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)&&dfs(i+1,j-1,s,dp)){
            return dp[i][j]=true;
        }
        else return dp[i][j]=false;
    }
}