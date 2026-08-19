class Solution {
    public int numDecodings(String s) {
        //every character of string can contribute two types of substring one with length of 1 character and other with length of 2 character;
        int n=s.length();
        if(s.charAt(0)=='0')return 0;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(0,0,n,s,dp);
    }
    public int dfs(int i,int prev,int n,String s,int[][] dp){
        //the base condition can be when it reaches the last index;
        if(i==n){
             String sb=s.substring(prev,i);
             if(sb.length()==0)return 0;
             if(sb.charAt(0)!='0'){
                int dig=Integer.parseInt(sb);
                if(dig>0&&dig<=26)return 1;
                else return 0;
             }
             else return 0;
        }
        if(i>n)return 0;
        if(dp[i][prev]!=-1)return dp[i][prev];
        //two options eiter to pick one or to pick two no.
        int one=0;
        int two=0;
        //while adding the digits too we need to check whether the dig starts with 0 or not and the dig is well above 0 but less than = 26;
        //for one digit->
        String sb=s.substring(i,i+1);
        if(sb.charAt(0)!='0'){
            one+=dfs(i+1,i,n,s,dp);
        }
        //befor adding 2 we need to check whether i+1 is less than n or not;
        if(i+1<n){
            String sb1=s.substring(i,i+2);
            if(sb1.charAt(0)!='0'){
                int dig=Integer.parseInt(sb1);
                if(dig>0&&dig<=26){
                    two+=dfs(i+2,i,n,s,dp);
                }
            }
        }
        return dp[i][prev]=one+two;
    }
}