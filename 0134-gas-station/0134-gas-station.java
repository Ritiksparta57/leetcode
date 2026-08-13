class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        //if total gas is less tahn cost then the journey cannot be completed;
        int gassum=0;
        int costsum=0;
        for(int i=0;i<n;i++){
            gassum+=gas[i];
            costsum+=cost[i];
        }
        if(gassum<costsum)return -1;
        //rest in all cases it is possible now we need to check which is the index where we start from;
        int total=0;
        int start=0;
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                start=i+1;
            }
        }
        return start;
    }
}