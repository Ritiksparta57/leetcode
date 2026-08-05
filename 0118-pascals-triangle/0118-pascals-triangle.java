class Solution {
    public List<List<Integer>> generate(int row) {
        int[][] dp=new int[row][row];
        for(int i=0;i<row;i++)Arrays.fill(dp[i],1);
        for(int i=1;i<row;i++){
            dp[i][0]=1;
            dp[i][i]=1;
            for(int j=1;j<i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        } 
       List<List<Integer>> l=new ArrayList<>();
       for(int i=0;i<row;i++)l.add(new ArrayList<>());
       for(int i=0;i<row;i++){
        for(int j=0;j<=i;j++){
            l.get(i).add(dp[i][j]);
        }
       }
       return l;
    }
}