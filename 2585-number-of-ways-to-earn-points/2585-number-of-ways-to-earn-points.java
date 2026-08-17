class Solution {
    int mod=(int)1e9+7;
    public int waysToReachTarget(int target, int[][] types) {
        int n=types.length;
        //we can select a type of coin from any index of types until types[i][0]>=0;
        //since the type[n][0]is also deciding whether to choose a particular index or not thus we need to add that state too;
        int[][][] dp=new int[n][target+1][51];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
        Arrays.fill(dp[i][j],-1);
            }
        }
        return dfs(n-1,types,target,dp,types[n-1][0]);
    }
    public int dfs(int n,int[][] type,int tar,int[][][] dp,int remtype){
        //base condition is when tar==0 and n==0;
        if(tar==0)return 1;
        if(n==0){
            //if the types[0] is greater than 0 and tar is divisble by type[1];
            if(tar%type[n][1]==0){
                //the target can be achieved at last index as it is divisible by last index one but the important thing is the last index's remainingtype should be greater than or equal to the asking no. of coins;
                //that is tar/type[n][1]<=remtype as that many coins we can spend only;
                if(remtype>=tar/type[n][1])return 1;
                else return 0;
            }
            else return 0;
        }
        if(remtype<0)return 0;
        if(dp[n][tar][remtype]!=-1)return dp[n][tar][remtype];
        //here too the skip and not skip will be used;
        int not=0;
        int pick=0;
        not+=dfs(n-1,type,tar,dp,type[n-1][0]);
        if(remtype>0&&tar>=type[n][1]){
            pick+=dfs(n,type,tar-type[n][1],dp,remtype-1);
        }
        return dp[n][tar][remtype]=(not+pick)%mod;
    }
}
//Another thing to keep in mind is if a dp is depending on multiple sources then make all those sources a dimension;