class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m=queries.length;
        int[] noofnodesgreaterthanmax=new int[n];
        int count=0;
        for(int i=1;i<n;i++){
            int max=Math.abs(nums[i]-nums[i-1]);
            if(max>maxDiff)count++;
            noofnodesgreaterthanmax[i]=count;
            //example:5-2=3;maxd=2 and i at 1(5)and i-1 at 1(2); since max>maxd count++ thus no of nodes that has greater difference than maxd is count;
        }
        //now we need to check that in the range given in queries whther the no. of nodes greater than max is equal or not.
        // if not equal then surely the difference in between the range is greter than maxd
        //exmple [1,3]-> nums[1]=5 and nums[3]=8;
        //noofnodes[1]=1 and nums[2]-nums[1]=1 noofnodes[2]=1;
        //nums[3]-nums[2]=2 noofnodes[3]=1 thus similar hence the node 3 is reachable from 1;
        //now [0,2]=> noofnodes[1]=nums[1]-nums[0]=3
        // 3>maxd. if 5 is not reachable from 2 then how will 6 be reachable as the diff between them will surely increase;
        // thus not possible;
        boolean[] answer=new boolean[m];
        int i=0;
        for(int[] q:queries){
            int u=q[0];
            int v=q[1];
            if(noofnodesgreaterthanmax[u]==noofnodesgreaterthanmax[v]){
                answer[i]=true;
            }
            else answer[i]=false;
            i++;
        } 
        return answer;
    }
}