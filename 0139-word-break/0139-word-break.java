class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //so initial feeling was correct;
        //we just store worddict in a set;
        //then we create a dp with boolean type for every character i in n;
        //the boolean dp at i getss true if there is a substring from i to i+k(which we call j that goes upto n) is there in the set and also if the other wordsin the string after the substring of i to i+k is met in set then we return true;
        //else return false;
        Set<String> st=new HashSet<>();
        for(String s1:wordDict)st.add(s1);
        //now create the dp;
        int n=s.length();
        Boolean[] dp=new Boolean[n];
        Arrays.fill(dp,null);
        return dfs(0,n,s,st,dp);
    }
    public boolean dfs(int i,int n,String s,Set<String> st,Boolean[] dp){
        //if we have reached the last of string then we surely have all the letters in set;
        if(i==n)return true;
        if(dp[i]!=null)return dp[i];
        //now here comes the main part;
        //we will make a for loop where we will start from i and then go till n and check for the string in set;
        for(int j=i;j<n;j++){
            String sb=s.substring(i,j+1);
            if(st.contains(sb)&&dfs(j+1,n,s,st,dp)){
               return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
}