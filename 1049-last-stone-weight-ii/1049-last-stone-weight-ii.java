class Solution {
    public int lastStoneWeightII(int[] stones) {
        //the stones array consists of rivaling groups of stones;
        //one with those which counterbalances the other array;
        //like 2,4 are in seperate arrays as they will counterbalance each other similarly 7 and 8;
        //but one thing is intresting and that is the sum of rivalling groups will be near to equal of sum/2;
        //after all both are same and counterbalance each other;
        //so we just need to find those subsets of array which will basically add up to sum/2 or remain near it;
        //this is a subset sum problem;
        int m=stones.length;
        int sum=0;
        for(int num:stones)sum+=num;
        int[][] dp=new int[m][(sum/2)+1];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        int closesum=dfs(0,0,m,sum/2,dp,stones);
        int remain=sum-closesum;
        return (int)Math.abs(closesum-remain);
    }
    public int dfs(int i,int sum,int m,int tar,int[][] dp,int[] stone){
        //base case is when the sum exceeds tar;
        //also when i becomes greater than equal to m;
        if(sum==tar)return sum;
        if(i>=m)return sum;
        if(dp[i][sum]!=-1)return dp[i][sum];
        //calculate the sum by either picking or not picking the stone;
        int not=0;
        int pick=sum;
        not=dfs(i+1,sum,m,tar,dp,stone);
        if(stone[i]+sum<=tar){
            pick=dfs(i+1,sum+stone[i],m,tar,dp,stone);
        } 
        return dp[i][sum]=Math.max(not,pick);
    }
}