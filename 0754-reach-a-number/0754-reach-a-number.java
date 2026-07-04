class Solution {
    public int reachNumber(int target) {
        int n=0;
        int sum=0;
        while(sum<Math.abs(target)||(sum-Math.abs(target))%2!=0){
            n++;
            sum+=n;
        }
        return n;
    }
}