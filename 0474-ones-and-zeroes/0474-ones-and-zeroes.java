class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //we are required to find the length of the biggest subset possible containing m 0 and n 1;
        //this does not mean less than m 0 and n 1 in one string but the whole string which we are adding to the subset;
        //so as we pick the string then we have to make sure that the string has less than m remaining 0's and n remaining 1's;
        //thus using knapsack;
        //but before that to ease the operation of finding 0's and 1's while we go through a string we make an array containing the sum of all 1's in that string;
        int k=strs.length;
        int[] ones=new int[k];
        for(int i=0;i<k;i++){
            int l=strs[i].length();
            int sum=0;
            for(int j=0;j<l;j++){
                if(strs[i].charAt(j)=='1'){
                    sum+=1;
                }
            }
            ones[i]=sum;
        }
        //now we just need to form a 3d dp containing the index,m,n as dimension;
        int[][][] dp=new int[k][m+1][n+1];
        for(int i=0;i<k;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return dfs(0,k,m,n,dp,ones,strs);
    }
    public int dfs(int i,int k,int m,int n,int[][][] dp,int[] ones,String[] strs){
        //base case-> 1.when either m or n has gone below 0;
        //2.when k is over;
        if(m<0||n<0)return 0;
        if(i>=k)return 0;
        if(dp[i][m][n]!=-1)return dp[i][m][n];
        //now the main logic is we pick a string or not pick a string;
        //since we are counting steps not the ways so we will add 1 for every pickup;
        int not=0;
        int pick=0; 
        not=dfs(i+1,k,m,n,dp,ones,strs);
        int l=strs[i].length();
        int zero=l-ones[i];
        if(ones[i]<=n&&zero<=m){
            pick=1+dfs(i+1,k,m-zero,n-ones[i],dp,ones,strs);
        }
        //from not and pick whoever brings higher no. of subset strings gets the place in dp;
       return dp[i][m][n]=Math.max(pick,not);
    }
}