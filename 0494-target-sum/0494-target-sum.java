//actaully every element in the array contributes two things :
//1.+x;
//2.-x;
//now till the last if all elements are taken in account we will have sum= summ of all
//and taking all elements as negative we will have -sum;
//so the farthest any sum can reach is -sum<=s<=+sum;
//and this applies to every element;
//so in order to find we will actually have a 2d dp with one dimension mentioning the index;
//the other dimension is od 2*sum size not sum as we are exploring 2*posiiblity of a sum;
//also for every element sum count we will maintain a currsum variable which basically adds up as it goes down;
//now you might be wondering what if currsum goes <0 then dp cannot store -index;
//this is correct thinking so for that at every currsum we will add sum to it;
//if currsum is +ve it will add to sum but will surely be less than 2*sum+1;(afterall we are creating sum again);
//if currsum is -ve then sum+currsum will surely be >=0 as the last currsum can reach is -sum and -sum+sum=0;
//also we are not gonna add sum directly in recursive call but the index will be used as currsum+sum which is then used in dp;
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)sum+=nums[i];
        int[][] dp=new int[n][2*sum+1];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-(int)1e9);
        //we are basically putting - in start of every index;
        //we will build sum at every index;
        //and then at every dfs call we will compare sum with target whether they are equal or not;
        //sum here is offset that is added to currsum(in dfs 0) to maintain the index in dp;
        return dfs(0,0,sum,n,target,dp,nums);
    }
    public int dfs(int i,int currsum,int sum,int n,int tar,int[][] dp,int[] nums){
        //base cnditions:
        //1.sum==tar;
        //2.i==n->nums[i]==tar->sum-i==tar->sum+i--tar;
        if(i==n){
            if(currsum==tar)return 1;
            else return 0;
        }
        int index=currsum+sum;
        if(dp[i][index]!=-(int)1e9)return dp[i][index];
        int not=0;
        int pick=0;
        not+=dfs(i+1,currsum+nums[i],sum,n,tar,dp,nums);
        pick+=dfs(i+1,currsum-nums[i],sum,n,tar,dp,nums);
        return dp[i][index]=not+pick;
    }
}