class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] stick=new int[m+2];
        stick[0]=0;
        for(int i=0;i<m;i++){
            stick[i+1]=cuts[i];
        }
        stick[m+1]=n;
        Arrays.sort(stick);
        //we are using 2d dp so that we may know what is the cost of breaking a stick within that range of i to j;
        int[][] dp=new int[m+2][m+2];
        for(int i=0;i<m+2;i++)Arrays.fill(dp[i],-1);
        return dfs(1,m,dp,stick);//1 is i ,m is j which is cuts last element;
    }
    public int dfs(int i,int j,int[][] dp,int[]stick){
        if(i>j)return 0;// when i exceeds j then there is no place to cut the stick;
        //that is cuts array is over;
        if(dp[i][j]!=-1)return dp[i][j];
        int cost=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){// this is to take every element as starting point and check which element gives u the least cost;
         int cost1=stick[j+1]-stick[i-1]+dfs(i,k-1,dp,stick)+dfs(k+1,j,dp,stick);
          cost=Math.min(cost,cost1);
        }
        return dp[i][j]=cost;
    }
}