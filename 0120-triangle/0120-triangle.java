class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //if we start from top and go till bottom then we will have multiple end points and all are not connected so multiple different answers;
        //thus it will be wise if we instead of starting from top we go from bottom to top this way we will cover all the required elements and meet at the top;
        //so we will run dfs from every element of last row;
        int m=triangle.size();
        int n=triangle.get(m-1).size();//the last row;
        //the thing is in minimum path sum we had a fixed enf=ding and starting point but here we have a fixed start but we do not have fixed end point all we have is we need to go to last row;
        //thus we start from last and go till first where ther is one element and then we find the least possible cost;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        int ans=(int)1e9;
        //we already have a fixed last row;
        for(int i=0;i<n;i++){
            int cost=dfs(m-1,i,dp,triangle,m,n);
            ans=Math.min(ans,cost);
        }
        return ans;
    }
    public int dfs(int i,int j,int[][] dp,List<List<Integer>> triangle,int m,int n){
        //the base case for it is if we get lost on the path then we return the highest possible value;
        //else if we reach the first index(top) then add it to the cost;
        if(i==0&&j==0){
            return triangle.get(i).get(j);
        }
        if(j<0||j>=triangle.get(i).size()){
           return (int)1e9;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        //now we get to recursive calls;
        int up=0;
        int upleft=0;
        if(j<triangle.get(i).size()){
        up=triangle.get(i).get(j)+dfs(i-1,j,dp,triangle,m,n);
        upleft=triangle.get(i).get(j)+dfs(i-1,j-1,dp,triangle,m,n);
        }
        return dp[i][j]=Math.min(up,upleft);
    }
}